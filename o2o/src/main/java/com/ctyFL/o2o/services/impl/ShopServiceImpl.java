package com.ctyFL.o2o.services.impl;

import java.io.InputStream;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ctyFL.o2o.dao.ShopDao;
import com.ctyFL.o2o.dto.ShopExecution;
import com.ctyFL.o2o.entity.Shop;
import com.ctyFL.o2o.enumeration.ShopStateEnum;
import com.ctyFL.o2o.exceptions.ShopOperationException;
import com.ctyFL.o2o.services.ShopService;
import com.ctyFL.o2o.util.ImageUtil;
import com.ctyFL.o2o.util.PathUtil;
/**
 * <p>Title: ShopServiceImpl</p>
 * <p>Description: ShopService接口的实现类</p>
 * @author ctyFL
 * @date 2021年1月22日
 */
//@Service：告诉springIOC这个实现类是需要被托管的，会将这个实现类自动注入到ShopService接口中去
@Service
public class ShopServiceImpl implements ShopService {
	
	/**
	 * @Autowired：希望spring自动将ShopDao的实现注入进来
	 */
	@Autowired
	private ShopDao shopDao;
	
	/**
	 * 添加商铺
	 * @Transactional：表明需要事务管理
	 */
	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {
		if(shop == null) {
			//返回错误信息
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			//设置状态为1：审核中
			shop.setStatus(ShopStateEnum.CHECK.getState());
			shop.setDataCreationDate(new Date());
			shop.setLastModifyTime(new Date());
			//成功插入条数
			int effectedNum = shopDao.insertShop(shop);
			if(effectedNum <= 0) {
				//这里用RuntimeException：因为当前程序只有抛出RuntimeException及RuntimeException的子类的Exception的时候，事务才会终止、回滚
				//创建了一个异常封装类（继承RuntimeException）
				throw new ShopOperationException("店铺创建失败");
			}else {
				if(shopImgInputStream != null) {
					try {
						//存储图片
						addShopImg(shop, shopImgInputStream, fileName);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error：" + e.getMessage());
					}
					//更新店铺图片路径地址
					effectedNum = shopDao.updateShop(shop);
					if(effectedNum <= 0) {
						throw new ShopOperationException("更新图片地址失败");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error：" + e.getMessage());
		}
		//返回待审核的返回参数
		return new ShopExecution(ShopStateEnum.CHECK, shop);
	}

	/**
	 * tempShop：修改后的Shop
	 * shopInputStream：若有传入新图片，则更新图片，若存在旧图片，将旧图片在文件中删除
	 * fileName：新图片的文件名
	 */
	@Override
	public ShopExecution updateShop(Shop tempShop, InputStream shopInputStream, String fileName)
			throws ShopOperationException {
		if(tempShop == null || tempShop.getID() == null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			return updateShopAndImg(tempShop, shopInputStream, fileName);
		} catch (Exception e) {
			throw new ShopOperationException("updateShop error：" + e.getMessage());
		}
	}

	@Override
	public Shop getShopByShopId(long shopId) {
		return shopDao.getShopById(shopId);
	}

	private ShopExecution updateShopAndImg(Shop tempShop, InputStream shopInputStream, String fileName) throws Exception {
		//1.若有传入新图片，则更新新图片，并将旧图片在文件中删除
		if(shopInputStream != null && fileName != null && !fileName.isEmpty()) {
			Shop oldShop = shopDao.getShopById(tempShop.getID());
			//若存在旧图片，则将旧图片在文件中删除
			if(oldShop.getImg() != null && !oldShop.getImg().isEmpty()) {
				ImageUtil.deleteFileOrDirectory(oldShop.getImg());
			}
			//更新新图片
			addShop(tempShop, shopInputStream, fileName);
		}
		//2.更新店铺
		tempShop.setLastModifyTime(new Date());
		int effectedNum = shopDao.updateShop(tempShop);
		if(effectedNum <= 0) {
			return new ShopExecution(ShopStateEnum.INNER_ERROR);
		}
		tempShop = shopDao.getShopById(tempShop.getID());
		return new ShopExecution(ShopStateEnum.SUCCESS, tempShop); 
	}
	
	/**
	 * 存储shop图片的相对路径
	 * @param shop
	 * @param shopImg
	 */
	private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
		//获取shop图片目录的相对路径
		String dest = PathUtil.getShopImgPath(shop.getID());
		String shopImgPath = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);
		shop.setImg(shopImgPath);
	}
	
}

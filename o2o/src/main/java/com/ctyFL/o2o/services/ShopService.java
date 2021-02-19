package com.ctyFL.o2o.services;

import java.io.InputStream;
import com.ctyFL.o2o.dto.ShopExecution;
import com.ctyFL.o2o.entity.Shop;
import com.ctyFL.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	/**
	 * 添加商铺
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
	/**
	 * 更新店铺
	 * @param tempShop 修改后的Shop
	 * @param shopInputStream 若有传入新图片，则更新图片，若存在旧图片，将旧图片在文件中删除
	 * @param fileName 新图片的文件名
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution updateShop(Shop tempShop, InputStream shopInputStream, String fileName) throws ShopOperationException;
	
	/**
	 * 根据ShopId返回Shop
	 * @param shopId
	 * @return
	 */
	Shop getShopByShopId(long shopId);
	
}

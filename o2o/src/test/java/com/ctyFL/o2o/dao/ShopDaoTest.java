package com.ctyFL.o2o.dao;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctyFL.o2o.BaseTest;
import com.ctyFL.o2o.entity.Shop;

/**
 * <p>Title: ShopDaoTest</p>
 * <p>Description: ShopDao的单元测试</p>
 * @author ctyFL
 * @date 2021年1月15日
 */
public class ShopDaoTest extends BaseTest {

	@Autowired
	ShopDao shopDao;
	
	@Test
	/*@Ignore：若此次测试不想执行这个方法*/
	@Ignore
	public void testInsertShop() {
		Shop shop = new Shop();
		shop.setName("测试商铺");
		shop.setDescription("测试");
		shop.setAddress("测试地址");
		shop.setPhone("测试联系电话：1213412412");
		shop.setImg("测试商铺图片");
		shop.setPriority(1);
		shop.setDataCreationDate(new Date());
		shop.setLastModifyTime(new Date());
		shop.setStatus(1);
		shop.setAdvice("测试管理员建议");
		shop.setArea_ID(1l);
		shop.setPersonInfo_ID(1l);
		shop.setShopType_ID(1l);
		int insertRows = shopDao.insertShop(shop);
		//成功插入条数是否为1
		assertEquals(1, insertRows);
		System.out.println("返回的Shop自增主键" + shop.getID());
	}
	
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop = new Shop();
		//查询数据得知测试Shop数据的ID=1
		shop.setID(1l);
		//对应映射文件ShopDao.xml要更新的字段
		shop.setDescription("Description测试更新");
		shop.setAddress("Address测试更新");
		shop.setPhone("Phone测试更新");
		shop.setImg("Img测试更新");
		shop.setAdvice("Advice测试更新");
		shop.setLastModifyTime(new Date());
		int updateRows = shopDao.updateShop(shop);
		//成功更新条数是否为1
		assertEquals(1, updateRows);
	}
	
	@Test
	public void testGetShopById() {
		long shopId = 3;
		Shop shop = shopDao.getShopById(shopId);
		System.out.println(shop.getName() + "," + shop.getAddress() + "...");
	}
	
}

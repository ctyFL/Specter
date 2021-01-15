package com.ctyFL.o2o.dao;

import static org.junit.Assert.assertEquals;
import java.util.Date;
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
}

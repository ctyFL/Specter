package com.ctyFL.o2o.services;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctyFL.o2o.BaseTest;
import com.ctyFL.o2o.dto.ShopExecution;
import com.ctyFL.o2o.entity.Shop;
import com.ctyFL.o2o.enumeration.ShopStateEnum;

/**
 * <p>Title: ShopServiceTest</p>
 * <p>Description: ShopService接口的单元测试</p>
 * @author ctyFL
 * @date 2021年1月29日
 */
public class ShopServiceTest extends BaseTest {

	@Autowired
	ShopService shopService;
	
	@Test
	public void addShopTest() {
		Shop shop = new Shop();
		shop.setName("测试商铺2");
		shop.setDescription("测试2");
		shop.setAddress("测试地址2");
		shop.setPhone("测试联系电话：1213412412");
		//shop.setImg("测试商铺图片");
		shop.setPriority(1);
		shop.setDataCreationDate(new Date());
		shop.setLastModifyTime(new Date());
		shop.setStatus(1);
		shop.setAdvice("测试管理员建议");
		shop.setArea_ID(1l);
		shop.setPersonInfo_ID(1l);
		shop.setShopType_ID(1l);
		
		File shopImg = new File("E:\\gitHubDev\\image\\testimg.png");
		ShopExecution execution = shopService.addShop(shop, shopImg);
		
		//判断添加商品并添加图片后，返回状态值是否是审核中
		assertEquals(ShopStateEnum.CHECK.getState(), execution.getState());
	}
	
}

package com.ctyFL.o2o.dao;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctyFL.o2o.BaseTest;
import com.ctyFL.o2o.entity.ShopType;
/**
 * <p>Title: ShopTypeDaoTest</p>
 * <p>Description: ShopTypeDao接口的单元测试</p>
 * @author ctyFL
 * @date 2021年2月12日
 */
public class ShopTypeDaoTest extends BaseTest {

	@Autowired
	ShopTypeDao shopTypeDao;
	
	@Test
	public void getShopTypeTest() {
		//此时数据库中共有两条ShopType数据，一条ParentId=0，一条ParentId=1
		/**
		 * 传入null
		 * 根据ShopType.xml中的where标签条件，shopCategoryCondition=null，会查询所有ShopType
		 */
		List<ShopType> list = shopTypeDao.getShopTypeList(null);
		assertEquals(2, list.size());
		
		/*
		 * 传入一个空的ShopType
		 * 根据ShopType.xml中的where标签条件，shopCategoryCondition!=null，会查询所有ParentId!=0的ShopType
		 */
		list = shopTypeDao.getShopTypeList(new ShopType());
		assertEquals(1, list.size());
		
		/*
		 * 传入ParentId=1的ShopType
		 * 根据ShopType.xml中的where标签条件，shopCategoryCondition.ParnetId!=null
		 * 会查询ParentId!=0且ParentId=shopCategoryCondition.ParnetId的ShopType
		 */
		ShopType shopType = new ShopType();
		shopType.setParentId(1L);
		list = shopTypeDao.getShopTypeList(shopType);
		assertEquals(1, list.size());
		System.out.println(list.get(0).getName());
	}
	
}

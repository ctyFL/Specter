package com.ctyFL.o2o.dao;

import com.ctyFL.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 新增店铺
	 * @param shop
	 * @return 返回成功新增条数，-1：失败
	 */
	int insertShop(Shop shop);
	
}

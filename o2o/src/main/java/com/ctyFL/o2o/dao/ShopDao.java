package com.ctyFL.o2o.dao;

import com.ctyFL.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 新增店铺
	 * @param shop
	 * @return 返回成功新增条数，-1：失败
	 */
	int insertShop(Shop shop);
	
	/**
	 * 更新店铺
	 * @param shop
	 * @return 返回成功更新条数，-1：失败
	 */
	int updateShop(Shop shop);
	
	/**
	 * 通过ShopId查询店铺
	 * @param shopId
	 * @return
	 */
	Shop getShopById(long shopId);
	
}

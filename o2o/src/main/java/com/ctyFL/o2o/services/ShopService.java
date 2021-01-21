package com.ctyFL.o2o.services;

import java.io.File;
import com.ctyFL.o2o.dto.ShopExecution;
import com.ctyFL.o2o.entity.Shop;

public interface ShopService {

	/**
	 * 添加商铺
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, File shopImg);
	
}

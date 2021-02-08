package com.ctyFL.o2o.services;

import java.io.InputStream;
import com.ctyFL.o2o.dto.ShopExecution;
import com.ctyFL.o2o.entity.Shop;
import com.ctyFL.o2o.exceptions.ShopOperationException;

public interface ShopService {

	/**
	 * 添加商铺
	 * @param shop
	 * @param shopImg
	 * @return
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
	
}

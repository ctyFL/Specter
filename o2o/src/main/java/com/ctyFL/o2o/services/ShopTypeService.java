package com.ctyFL.o2o.services;

import java.util.List;
import com.ctyFL.o2o.entity.ShopType;

public interface ShopTypeService {
	
	List<ShopType> getShopTypeList(ShopType shopCategoryCondition);
	
}

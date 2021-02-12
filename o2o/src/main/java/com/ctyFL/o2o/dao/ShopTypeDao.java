package com.ctyFL.o2o.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ctyFL.o2o.entity.ShopType;

public interface ShopTypeDao {
	
	List<ShopType> getShopTypeList(@Param("shopCategoryCondition") ShopType shopCategoryCondition);

}

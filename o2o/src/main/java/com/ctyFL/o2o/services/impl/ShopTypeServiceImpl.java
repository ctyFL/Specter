package com.ctyFL.o2o.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ctyFL.o2o.dao.ShopTypeDao;
import com.ctyFL.o2o.entity.ShopType;
import com.ctyFL.o2o.services.ShopTypeService;
/**
 * <p>Title: ShopTypeServiceImpl</p>
 * <p>Description: ShopTypeService接口的实现类</p>
 * @author ctyFL
 * @date 2021年2月12日
 */
@Service
public class ShopTypeServiceImpl implements ShopTypeService {

	@Autowired
	private ShopTypeDao shopTypeDao;
	
	@Override
	public List<ShopType> getShopTypeList(ShopType shopCategoryCondition) {
		return shopTypeDao.getShopTypeList(shopCategoryCondition);
	}

}

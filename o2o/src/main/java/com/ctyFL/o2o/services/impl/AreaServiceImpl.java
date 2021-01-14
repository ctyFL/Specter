package com.ctyFL.o2o.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ctyFL.o2o.dao.AreaDao;
import com.ctyFL.o2o.entity.Area;
import com.ctyFL.o2o.services.AreaService;

/**
 * @Service：告诉springIOC这个实现类是需要被托管的，会将这个实现类自动注入到AreaService接口中去
 */
@Service
public class AreaServiceImpl implements AreaService {
	
	/**
	 * @Autowired：希望spring自动将AreaDao的实现注入进来
	 */
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {
		return areaDao.getAreaList();
	}

}

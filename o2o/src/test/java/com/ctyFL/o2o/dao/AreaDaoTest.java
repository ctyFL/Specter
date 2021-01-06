package com.ctyFL.o2o.dao;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctyFL.o2o.BaseTest;
import com.ctyFL.o2o.entity.Area;
/**
 * <p>Title: AreaDaoTest</p>
 * <p>Description: AreaDao单元测试</p>
 * @author ctyFL
 * @date 2021年1月7日
 */
public class AreaDaoTest extends BaseTest {
	
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaDao.getAreaList();
		//判断查询到的数据是否是两条
		assertEquals(2, areaList.size());
	}
	
}

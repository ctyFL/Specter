package com.ctyFL.o2o.services;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ctyFL.o2o.BaseTest;
import com.ctyFL.o2o.entity.Area;

/**
 * <p>Title: AreaServiceTest</p>
 * <p>Description: AreaService接口的单元测试</p>
 * @author ctyFL
 * @date 2021年1月13日
 */
public class AreaServiceTest extends BaseTest {

	/**
	 * 因为AreaServiceImpl.java中使用了@Sercvice注解，告诉了springIOC需要被托管
	 * 所以这里使用@Autowired会将AreaServiceImpl自动注入到AreaService接口中
	 */
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() {
		List<Area> list = areaService.getAreaList();
		//判断获取到的数据是否是两条
		assertEquals(2, list.size());
	}
}

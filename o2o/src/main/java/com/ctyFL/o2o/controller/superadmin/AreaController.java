package com.ctyFL.o2o.controller.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ctyFL.o2o.entity.Area;
import com.ctyFL.o2o.services.AreaService;

/**
 * @Controller：作用和@Service类似，告诉了springIOC需要被作为Controller来托管
 * @RequestMapping：指定路由，处理请求地址映射
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {

	Logger logger = LoggerFactory.getLogger(AreaController.class);
	
	/**
	 * 因为AreaServiceImpl.java中使用了@Sercvice注解，告诉了springIOC需要被托管
	 * 所以这里使用@Autowired会将AreaServiceImpl自动注入到AreaService接口中
	 */
	@Autowired
	AreaService areaService;
	
	/**
	 * 获取所有区域
	 * 
	 * @RequestMapping：
	 * 				value：指定请求的实际地址
	 * 				method：指定请求的方式
	 * @ResponseBody：
	 * 				将方法的返回值，以特定的格式写入到response的body区域，进而将数据返回给客户端。
	 * 				当方法上面没有写ResponseBody，底层会将方法的返回值封装为ModelAndView对象。
	 * 				如果返回值是字符串，那么直接将字符串写到客户端；如果是一个对象，会将对象转化为json串，然后写到客户端。
	 * @return
	 */
	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listArea() {
		logger.info("=====start=====");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = new ArrayList<Area>();
		try {
			list = areaService.getAreaList();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());
		}catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}
		long endTime = System.currentTimeMillis();
		logger.error("test error!");
		logger.debug("costTime：[{}ms]", endTime - startTime);
		logger.info("=====end=====");
		return modelMap;
	}
}

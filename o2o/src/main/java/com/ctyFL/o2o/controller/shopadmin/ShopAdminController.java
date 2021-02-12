package com.ctyFL.o2o.controller.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="shopadmin", method={RequestMethod.GET})
public class ShopAdminController {

	@RequestMapping(value="/shopoperation")
	/**
	 * 返回的字符串就是要访问的资源路径
	 */
	public String shopOperation() {
		/**
		 * 在spring-web.xml中的定义视图解析器的配置，配置了前后缀
		 * 所以返回shop/shopoperation就能找到是html下的shop下的shopoperation的html资源
		 */
		return "shop/shopoperation";
	}
	
}

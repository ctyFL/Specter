package com.ctyFL.o2o.controller.shopadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import com.ctyFL.o2o.dto.ShopExecution;
import com.ctyFL.o2o.entity.Area;
import com.ctyFL.o2o.entity.Shop;
import com.ctyFL.o2o.entity.ShopType;
import com.ctyFL.o2o.enumeration.ShopStateEnum;
import com.ctyFL.o2o.exceptions.ShopOperationException;
import com.ctyFL.o2o.services.AreaService;
import com.ctyFL.o2o.services.ShopService;
import com.ctyFL.o2o.services.ShopTypeService;
import com.ctyFL.o2o.util.CodeUtil;
import com.ctyFL.o2o.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * <p>Title: ShopManagementController</p>
 * <p>Description: 店铺Controller</p>
 * @author ctyFL
 * @date 2021年2月06日
 * @Controller：作用和@Service类似，告诉了springIOC需要被作为Controller来托管
 * @RequestMapping：指定路由，处理请求地址映射
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
	
	Logger logger = LoggerFactory.getLogger(ShopManagementController.class);
	
	/**
	 * 因为ShopServiceImpl.java中使用了@Sercvice注解，告诉了springIOC需要被托管
	 * 所以这里使用@Autowired会将ShopServiceImpl自动注入到ShopService接口中
	 */
	@Autowired
	private ShopService service;
	
	@Autowired
	private ShopTypeService shopTypeService;
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * 注册店铺
	 * @param request
	 * @return
	 * 
	 * @RequestMapping：
	 * 				value：指定请求的实际地址
	 * 				method：指定请求的方式
	 * @ResponseBody：
	 * 				将方法的返回值，以特定的格式写入到response的body区域，进而将数据返回给客户端。
	 * 				当方法上面没有写ResponseBody，底层会将方法的返回值封装为ModelAndView对象。
	 * 				如果返回值是字符串，那么直接将字符串写到客户端；如果是一个对象，会将对象转化为json串，然后写到客户端。
	 */
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		//1.接收并转换相应的参数，包括商铺信息、图片信息
		String jsonStr = HttpServletRequestUtil.getStringValue(request, "jsonStr");
		if(!CodeUtil.checkVerifyCode(request)) {
			modelMap.put("success", false);
			modelMap.put("errMsg", "验证码错误！");
			return modelMap;
		}
		//jackson-databind工具类
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(jsonStr, Shop.class);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		//spring自带的接收文件的类
		CommonsMultipartFile shopImg = null;
		//文件上传解析器：从request的本次回话的上下文去获取相关文件上传的内容
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(resolver.isMultipart(request)) {//判断request里是否存在上传的文件流
			//将HttpServletRequest强转成MultipartHttpServletRequest，就能获取上传的文件流了
			MultipartHttpServletRequest multiPartRequest = (MultipartHttpServletRequest) request;
			//将获取的文件流强转成spring能够处理的文件流CommonsMultipartFile
			shopImg = (CommonsMultipartFile) multiPartRequest.getFile("shopImg");
		}else {//若request中不存在上传的文件流
			modelMap.put("success", false);
			modelMap.put("errMsg", "上传图片不能为空");
			return modelMap;
		}
		//2.注册店铺
		if(shop != null && shopImg != null) {
			//Session TODO
			shop.setPersonInfo_ID(1l);
			/**
			 * 这里不合理，因为每次都要去创建一个空文件，然后把上传的文件流写入进去，而写入的时候又容易抛出异常，大大的增加了系统的不稳定性
			 * 因此需要做重构：将ShopService接口的addShop方法的传入File文件改成直接传入InputStream流
			 * 重构后将以下代码注释
			 */
//			File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
//			try {
//				shopImgFile.createNewFile();
//				inputStreamToFile(shopImg.getInputStream(), shopImgFile);
//			} catch (IOException e) {
//				e.printStackTrace();
//				modelMap.put("success", false);
//				modelMap.put("errMsg", e.getMessage());
//				return modelMap;
//			}
//			ShopExecution se = service.addShop(shop, shopImgFile);
//			if(se.getState() == ShopStateEnum.CHECK.getState()) {
//				modelMap.put("success", true);
//			}else {
//				modelMap.put("success", false);
//				modelMap.put("errMsg", se.getStateInfo());
//			}
			ShopExecution se;
			try {
				se = service.addShop(shop, shopImg.getInputStream(), shopImg.getOriginalFilename());
				if(se.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
				}else {
					modelMap.put("success", false);
					modelMap.put("errMsg", se.getStateInfo());
				}
			} catch (ShopOperationException e) {
				e.printStackTrace();
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			//3.返回结果
			return modelMap;
		}else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "店铺信息不能为空");
			return modelMap;
		}
	}
	
	/**
	 * 获取店铺类别列表、区域列表
	 * @return
	 */
	@RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getShopInitInfo() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<ShopType> shopTypeList = new ArrayList<ShopType>();
		List<Area> areaList = new ArrayList<Area>();
		try {
			//注册时，控制注册的店铺不能直接在一级店铺下，而是至少在二级店铺下，所以返回ParentId!=0的所有店铺填充下拉选
			shopTypeList = shopTypeService.getShopTypeList(new ShopType());
			areaList = areaService.getAreaList();
			modelMap.put("success", true);
			modelMap.put("shopCategoryList", shopTypeList);
			modelMap.put("areaList", areaList);
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
		}
		return modelMap;
	} 
	
	/**
	 * 将InputStream流转换成文件，重构ShopService接口addShop方法后（把原来的传入File）
	 * @param in
	 * @param file
	 * 重构后将此方法注释
	 */
//	private static void inputStreamToFile(InputStream in, File file) {
//		FileOutputStream os = null;
//		try {
//			os = new FileOutputStream(file);
//			int bytesRead = 0;
//			byte[] buffer = new byte[1024];
//			while((bytesRead = in.read(buffer)) != -1) {
//				os.write(buffer, 0, bytesRead);
//			}
//		} catch (Exception e) {
//			throw new RuntimeException("调用inputStreamToFile发生异常：" + e.getMessage());
//		} finally {
//			try {
//				if(os != null) {
//					os.close();
//				}
//				if(in != null) {
//					in.close();
//				}
//			} catch (IOException ex) {
//				throw new RuntimeException("inputStreamToFile关闭IO发生异常：" + ex.getMessage());
//			}
//		}
//	}

}

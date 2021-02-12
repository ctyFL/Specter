**01createMavenProject**

	1.创建maven项目

	2.配置本地maven环境，使用本地maven仓库，setting.xml中配置阿里云镜像


**02SystemModuleDivisionAndCreateEntity**

	3.划分系统模块
	
	4.创建实体、创建数据库相应表


**03buildSSMProjectStructure**

	5.搭建SSM项目结构：完善项目目录结构
	
	6.完善项目配置pom.xml：Spring依赖、数据库交互相关、其他必要工具类依赖
	
  
**04updateSSMconfiguration**

	7.创建jdbc.properties
	
	8.创建mybatis-config.xml
	
	9.创建Spring相关配置：spring-dao.xml
	
	10.创建Spring相关配置：spring-service.xml
	
	11.创建Spring相关配置：spring-web.xml
	
	12.web.xml中整合Spring相关配置
	
	
**05buildDaoInterface**

	13.编写AreaDao接口：com.ctyFL.o2o.dao.AreaDao.java
	
	14.编写mapper.xml：src/main/resources/mapper/AreaDao.xml
	
	15.编写单元测试：src/test/java：
			com.ctyFL.o2o.BaseTest.java
			com.ctyFL.o2o.dao.AreaDaoTest.java
			
			
**06buildServices**

	16.编写AreaService接口：com.ctyFL.o2o.services.AreaService.java
	
	17.编写AreaService接口的实现类：com.ctyFL.o2o.services.impl.AreaServiceImpl.java
	
	18.BaseTest.java添加读取spring-service.xml配置：@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
	
	19.编写单元测试：src/test/java：com.ctyFL.o2o.services.AreaServiceTest.java


**07buildController**

	20.编写AreaController接口：com.ctyFL.o2o.controller.superadmin.AreaController.java
	
	
**08uselogback**

	21.编写logback.xml配置文件：src/main/resources：logback.xml


**09shopRegister**

	01编写ShopDao接口：
		01.创建接口：com.ctyFL.o2o.dao.ShopDao.java并编写插入Shop方法
		02.编写ShopDao接口的mybatis数据库映射配置文件：ShopDao.xml，并编写插入Shop配置
		03.数据库插入测试数据：PersonInfo、ShopType
		04.编写单元测试：com.ctyFL.o2o.dao.ShopDaoTest
		05.ShopDao.java接口中新增更新Shop方法
		06.ShopDao.xml中新增更新Shop配置
		07.单元测试更新Shop

	02使用Thumbnailator图片处理和封装Util：
		01.pom.xml添加Thumbnailator工具类的依赖
		02.准备好测试图片和水印图片：E:\gitHubDev\image\testimg、src\main\resources\image\icon和src\test\resources\image\icon下icon_fl.png
		03.编写单元测试：com.ctyFL.o2o.util.ImageUtilTest
		04.编写路径工具类：com.ctyFL.o2o.util.PathUtil
		05.编写图片处理工具类：com.ctyFL.o2o.util.ImageUtilTest

	03注册店铺的Service层：
		01.创建操作店铺的状态的枚举类：com.ctyFL.o2o.enumeration.ShopStateEnum、操作店铺的返回参数的封装类：com.ctyFL.o2o.dto.ShopExecution
		02.创建Service接口及其实现类：com.ctyFL.o2o.services.ShopService、com.ctyFL.o2o.services.impl.ShopServiceImpl
		03.封装异常类并在实现类中使用异常类：com.ctyFL.o2o.exceptions.ShopOperationException
		04.编写ShopService接口的单元测试：com.ctyFL.o2o.services.ShopServiceTest

	04注册店铺的Controller层：
		01.pom.xml引入jackson-databind依赖（json与实体类互相转换的工具类）
		02.编写HttpServletRequest参数的工具类：com.ctyFL.o2o.util.HttpServletRequestUtil
		03.编写ShopController：com.ctyFL.o2o.controller.shopadmin.ShopManagementController
		04.重构ShopService接口的addShop方法：
				addShop(Shop shop, File file)——>addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException
			（原先传入File是为了方便测试，后期发现Controller中每次都创建一个空文件，将上传的文件流写入文件，并且容易发生写入异常，所以不合理）
		05.重构：修改ShopService、ShopServiceImpl、ImageUtil、ShopManagementController、ShopServiceTest中相应代码

	05注册店铺前端设计：
		01.使用前端UI框架SUI Mobile：下载所需静态资源（css\js）并引入工程，模仿表单示例创建店铺信息表单页面（WEB-INFO/html/shop/shopoperation.html）并引入SUI的静态资源
		02.创建ShopAdminController负责控制用户访问的路由、配置访问请求的转发（/shopadmin/shopoperation）
		03.创建店铺信息（注册）页面的js：resources/js/shop/shopoperation.js（初始化数据即获取店铺类别列表及区域列表数据、提交表单方法），shopoperation.html中引入该js
		04获取店铺类别列表、区域列表的后台实现：ShopTypeDao接口、ShopTypeDao.xml、ShopTypeDaoTest、ShopTypeService接口及实现类ShopTypeServiceImpl、
			ShopManagementController中添加方法getShopInitInfo
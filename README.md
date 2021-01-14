**01createMavenProject**

	1.创建maven项目

	2.配置本地maven环境，使用本地maven仓库


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

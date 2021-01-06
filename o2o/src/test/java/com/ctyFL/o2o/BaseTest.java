package com.ctyFL.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title: BaseTest</p>
 * <p>Description: 配置spring和junit整合，junit启动时加载springIOC容器</p>
 * @author ctyFL
 * @date 2021年1月7日
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class BaseTest {

}

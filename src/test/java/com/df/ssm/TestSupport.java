package com.df.ssm;


import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:spring/spring-core.xml", 
		"classpath:spring/spring-mybatis.xml",
		"classpath:spring/spring-beans.xml",
		"classpath:spring/spring-timer.xml" })
public abstract class TestSupport {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	static {
		try {
			DOMConfigurator.configure(TestSupport.class.getResource("test.xml"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

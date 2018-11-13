package com.df.ssm.commons;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.xml.DOMConfigurator;


@WebListener
public class Log4jLoader implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			DOMConfigurator.configure(Log4jLoader.class.getResource("/log4j.xml"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}

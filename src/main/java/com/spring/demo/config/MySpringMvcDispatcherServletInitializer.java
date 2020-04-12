/**
 * Gagandeep
 * 10:40:12 am
 * 12-Apr-2020
 */
package com.spring.demo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Creating Servlet Dispatcher using Java config
 */
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Similar to making a reference to spring-servlet.xml
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	/**
	 * Specifying url Mapping
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

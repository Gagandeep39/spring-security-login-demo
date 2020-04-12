/**
 * Gagandeep
 * 10:35:56 am
 * 12-Apr-2020
 */
package com.spring.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * NOTESometimes the src/main/java is not created 
 * Manually created java folder inside main before creating a package
 *
 * AppConfig Class is a Java Config Suvstute of spring-servlet.xml
 */

@EnableWebMvc
@Configuration
@ComponentScan("com.spring.demo")
public class AppConfig {
	
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}

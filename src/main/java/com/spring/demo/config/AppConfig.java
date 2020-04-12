/**
 * Gagandeep
 * 10:35:56 am
 * 12-Apr-2020
 */
package com.spring.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * NOTESometimes the src/main/java is not created 
 * Manually created java folder inside main before creating a package
 *
 * AppConfig Class is a Java Config Suvstute of spring-servlet.xml
 */

@EnableWebMvc
@Configuration
@ComponentScan("com.spring.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {
	
	/**
	 * Golds data from properties file'
	 * Automatically reads data from property files in classpath
	 */
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * View Reolver
	 * @return ViewResolver
	 */
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/**
	 * Data srouce for reading my sql file
	 * @return DataSource
	 */
	@Bean
	public DataSource getDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
			dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
			dataSource.setUser(env.getProperty("jdbc.user"));
			dataSource.setPassword(env.getProperty("jdbc.password"));
			dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
			dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
			dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
			dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		return dataSource;
	}

	/**
	 * Could have read directly 
	 * Its always better to create  a helper method
	 * @return int
	 */
	private int getIntProperty(String string) {
		String propertyValue = env.getProperty(string);
		int intValue = Integer.parseInt(propertyValue);
		return intValue;
	}

}

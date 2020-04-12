/**
 * Gagandeep
 * 11:05:39 am
 * 12-Apr-2020
 */
package com.spring.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

/**
 * Enable websecurity implies this class has ecirity configuration
 * Spring now provides a default login page
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * Overriding COnfigure class and creating users
	 * Using porebuit User entity with username, password, roles
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder userBuilder = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(userBuilder.username("gagan").password("123456").roles("ADMIN"))
		.withUser(userBuilder.username("employee").password("123456").roles("EMPLOYEE"))
		.withUser(userBuilder.username("manager").password("123456").roles("MANAGER"));
		
		
	}

}

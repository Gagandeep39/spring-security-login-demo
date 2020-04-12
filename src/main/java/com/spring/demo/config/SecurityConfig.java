/**
 * Gagandeep
 * 11:05:39 am
 * 12-Apr-2020
 */
package com.spring.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
		.withUser(userBuilder.username("gagan").password("123456").roles("ADMIN", "EMPLOYEE", "MANAGER"))	// Can have multiple roles
		.withUser(userBuilder.username("employee").password("123456").roles("EMPLOYEE", "ADMIN"))
		.withUser(userBuilder.username("manager").password("123456").roles("MANAGER", "EMPLOYEE"));
		
		
	}
	
	/**
	 * COngigure method allows us to modify default security settings of spring security
	 * 
	 * Create our own login page
	 * Doesnt provide any error handling by default
	 * 
	 * permitAll -> Gives permission to all
	 * antMatchers -> Add restriction in page access based on roles
	 * and -> Expression to add multiple features(eg. role based auth, custom login page, custom ogout page, exception handling)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").hasRole("EMPLOYEE")
		.antMatchers("/managers/**").hasRole("MANAGER")
		.antMatchers("/admins/**").hasRole("ADMIN")
		.and()											// Below code shows a custom login form
		.formLogin()
		.loginPage("/showMyLoginPage")					//pth to login page to be shown
		.loginProcessingUrl("/authenticateTheUser")		//path to submit actionn 
		.permitAll() 									//allow everone to the the page
		.and() 											// Add logout functionality
		.logout()	
		.permitAll()
		.and()											// Below code shows an access denied page on Exception
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");	
	}

}

/**
 * Gagandeep
 * 11:02:27 am
 * 12-Apr-2020
 */
package com.spring.demo.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Simple extending this class will initialize security
 * NOTE: After initializing security, create a  new class and extend WebSecurityConfigurerAdapter
 * Override configure(auth) method and create users as spring will prodide its default login page
 */
public class MySecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}

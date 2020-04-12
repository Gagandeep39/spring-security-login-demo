/**
 * Gagandeep
 * 10:44:22 am
 * 12-Apr-2020
 */
package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Login Servlet
 *
 */
@Controller
public class LoginController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}

}
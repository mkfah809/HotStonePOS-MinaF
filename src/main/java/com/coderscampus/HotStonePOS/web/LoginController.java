package com.coderscampus.HotStonePOS.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/login")
		public String login() {
		System.out.println("login page");
		return "login";
	}
}

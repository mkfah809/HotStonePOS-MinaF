package com.coderscampus.HotStonePOS.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class LoginController {
	
	@RequestMapping("/")
	public String getRedirectWelcomePage() {
		return ("redirect://localhost:8080/login");
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}

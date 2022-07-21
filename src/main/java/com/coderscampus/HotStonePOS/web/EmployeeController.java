package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService empService;

	@RequestMapping("/")
	public String getRedirectWelcomePage() {
		return ("redirect://localhost:8080/register/new/employee");
	}

	@GetMapping("/register/new/employee")
	public String getCreateEmployee(ModelMap model) {
		model.put("employee", new Employee());
		return "register";
	}

	@PostMapping("/register/new/employee")
	public String postCreateEmployee(Employee emp) {
		empService.createEmp(emp);
		return "sign-in";
	}

	@GetMapping("/sign-in")
	public String getSignIn() {
		return "sign-in";
	}

}
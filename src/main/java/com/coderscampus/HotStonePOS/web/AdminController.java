package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.HotStonePOS.domain.Authority;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.repository.AuthorityRepository;
import com.coderscampus.HotStonePOS.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	
	@GetMapping("/register/new/employee")
	public String getCreateEmployee(ModelMap model) {
		model.put("employee", new Employee());
		return "register";
	}

	@PostMapping("/register/new/employee")
	@ResponseBody
	public String postCreateEmployee(@RequestBody(required = true) Employee emp, Authority auth) {
		adminService.createNewEmployee(emp, auth);
		adminService.setAuthorityToUser(emp, auth);
		return "redirect:/register/new/employee/created";
	}
}
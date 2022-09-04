package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.service.AdminService;

@Controller
//@RequestMapping("/users")
public class AdminController {

	@Autowired
	AdminService adminService;

//	@ResponseBody
	@GetMapping("/register/new/employee")
	public String getCreateEmployee(ModelMap model, @AuthenticationPrincipal Employee emp) {
		System.out.println("XXX" + emp.getId());
		Employee findById = adminService.findById(emp.getId());
		model.put("employee", new Employee());
		return "register";
	}

	@PostMapping("/register/new/employee")
	public String postCreateEmployee(@RequestBody Employee emp) {
		adminService.createNewEmployee(emp);
		return "redirect:/register";
	}
}
package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.service.AdminService;

@Controller
public class DashboardController {
	@Autowired
	AdminService adminService;

	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal Employee emp, ModelMap model) throws Exception {

		Employee findById = adminService.findById(emp.getId());
		System.out.println("dashboard page  " + findById.getId());

		try {
			model.put("employee", emp);
		} catch (Exception e) {
			throw new Exception("Sorry, you don't have authorization to access this page.");
		}
		return "dashboard";
	}
}

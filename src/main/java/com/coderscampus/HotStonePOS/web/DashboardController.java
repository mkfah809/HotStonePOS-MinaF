package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coderscampus.HotStonePOS.domain.Authority;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.service.AdminService;

@Controller
public class DashboardController {
	@Autowired
	AdminService adminService;

	@GetMapping("/dashboard/{empId}")
	public String getDashboard(@PathVariable Long empId, ModelMap model, Authority auth) throws Exception {
		Employee emp = adminService.findById(empId);
		try {
			model.put("employee", emp);
			model.put("access", emp.getAuthorities().iterator().next());
			
		} catch (Exception e) {
			throw new Exception("Sorry, you don't have authorization to access this page.");
		}
		return "dashboard";
	}
}

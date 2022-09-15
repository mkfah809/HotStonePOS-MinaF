package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.coderscampus.HotStonePOS.domain.Authority;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.service.AdminService;

@Controller
public class DashboardController {
	@Autowired
	AdminService adminService;
	
 	@GetMapping("/dashboard")
	public String getDashboard(@AuthenticationPrincipal Employee emp, ModelMap model, Authority auth) throws Exception {
		adminService.findById(emp.getId());
		try {
			model.put("employee", emp);
			model.put("access", emp.getAuthorities().iterator().next());

		} catch (Exception e) {

			model.put("error", new Exception("Sorry, you don't have authorization to access this page."));
			throw new Exception("Sorry, you don't have authorization to access this page.");
		}
		return "dashboard";
	}
}

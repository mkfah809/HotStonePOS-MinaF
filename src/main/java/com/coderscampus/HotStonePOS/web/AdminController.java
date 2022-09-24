package com.coderscampus.HotStonePOS.web;

import java.util.List;

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
import com.coderscampus.HotStonePOS.service.AdminService;
import com.coderscampus.HotStonePOS.service.AuthorityService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	AuthorityService authService;

	@GetMapping("/register/new/employee")
	public String getCreateEmployee(ModelMap model) {
		model.put("employee", new Employee());
		return "register";
	}

	@PostMapping("/register/new/employee")
	@ResponseBody
	public String createEmployee(@RequestBody Employee emp, Authority auth) {
		adminService.createOrUpdateEmployee(emp);
		authService.setAuthorityToUser(emp, auth);
		return "redirect:/register/new/employee";
	}

	@GetMapping("/dashboard/about-me/{empId}")
	public String getExistingEmployee(@AuthenticationPrincipal Employee emp, ModelMap model, @PathVariable Long empId)
			throws Exception {
		try {
			if (empId != null) {
				model.put("employee", adminService.findById(empId));			
			} else {
				model.put("error", new Exception("Sorry, id is empty"));
			}
		} catch (Exception e) {
			model.put("error", new Exception("Sorry, you don't have authorization to access this page."));
		}
		return "about";
	}

	@PostMapping("/dashboard/about-me/{empId}")
	public String updateExistingEmployee(Employee emp) {
		adminService.createOrUpdateEmployee(emp);
		return "redirect:/dashboard/about-me/" + emp.getId();
	}

	@GetMapping("/dashoard/employees/{empId}")
	public String getListEmployees(ModelMap model, @PathVariable Long empId) {
		List<Employee> employees = adminService.findAll();
		Employee employee = adminService.findById(empId);
//		model.put("employee", employee);
		model.put("employees", employees);
		return "employees";
	}

	@PostMapping("/dashoard/employees/delete/{empId}")
	public String deleteExistingEmployee(Long empId) {
		System.out.println("Deleting A User" + empId);
		Employee emp = adminService.findById(empId);
		adminService.delete(empId);
		return "redirect:/dashoard/employees/{empId}";
	}
}
package com.coderscampus.HotStonePOS.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.HotStonePOS.domain.Authority;
import com.coderscampus.HotStonePOS.domain.Employee;

@Service
public class EmployeeService {

	@GetMapping("@{about-me/{empId}")
	public String postCreateEmployee(@PathVariable Long empId) {
	return "about";
	}
}

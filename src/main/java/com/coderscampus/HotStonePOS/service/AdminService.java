package com.coderscampus.HotStonePOS.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.repository.EmployeeRepository;

@Service
public class AdminService {
	private EmployeeRepository empRepo;
	
	@Secured({"ROLE_ADMIN"})
	public Employee createNewEmployee(Employee emp) {
		return empRepo.save(emp);
	}
}

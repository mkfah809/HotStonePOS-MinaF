package com.coderscampus.HotStonePOS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.repository.EmployeeRepository;

@Service
public class AdminService {
	@Autowired
	private EmployeeRepository empRepo;

	@Secured({"ROLE_ADMIN" })
	public Employee createNewEmployee(Employee emp) {
		return empRepo.save(emp);
	}

	public Employee findById(Long id) {
		Optional<Employee> findById = empRepo.findById(id);
		System.out.println();
		return findById.orElse(null);
	}
}

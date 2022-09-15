package com.coderscampus.HotStonePOS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Authority;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.repository.AuthorityRepository;
import com.coderscampus.HotStonePOS.repository.EmployeeRepository;

@Service
public class AdminService {
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private AuthorityRepository authRepo;

	public Employee createNewEmployee(Employee emp, Authority auth) {
		emp.setPassword(new BCryptPasswordEncoder().encode(emp.getPassword()));

		return empRepo.save(emp);

	}

	public Employee findById(Long id) {
		Optional<Employee> findById = empRepo.findById(id);
		System.out.println();
		return findById.orElse(null);
	}

	public Authority setAuthorityToUser(Employee emp, Authority auth) {
		
		if (emp.getTitle().equalsIgnoreCase("M")) {
			auth.setAuthority("ROLE_ADMIN");
		} else {
			auth.setAuthority("ROLE_USER");

		}
		auth.setEmp(emp);
		return authRepo.save(auth);
	}

}

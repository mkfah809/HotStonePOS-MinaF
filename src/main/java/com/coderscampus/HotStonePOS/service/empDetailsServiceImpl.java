package com.coderscampus.HotStonePOS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.repository.EmployeeRepository;
import com.coderscampus.HotStonePOS.security.CustomSecurityEmp;

@Service
public class empDetailsServiceImpl implements UserDetailsService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public UserDetails loadUserByUsername(String empUsername) throws UsernameNotFoundException {
		Employee emp = empRepo.findByEmpUsername(empUsername);

		if (emp == null) {
			System.out.println("Emp is null");
			throw new UsernameNotFoundException("Username and or Password was incorrect");
		}
		System.out.println(emp.getEmpUsername());
		System.out.println(emp.getEmpPassword());
		System.out.println(emp.getAuthorities());
		// map emp => empDetail
		return new CustomSecurityEmp(emp);
	}

}

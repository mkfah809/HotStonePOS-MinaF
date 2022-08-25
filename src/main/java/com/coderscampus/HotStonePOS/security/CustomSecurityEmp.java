package com.coderscampus.HotStonePOS.security;


import org.springframework.security.core.userdetails.UserDetails;

import com.coderscampus.HotStonePOS.domain.Employee;


public class CustomSecurityEmp extends Employee implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomSecurityEmp(){} //Spring Req.
	
	public CustomSecurityEmp(Employee emp) {
		this.setAuthorities(emp.getAuthorities());
		this.setEmpId(emp.getEmpId());
		this.setEmpPassword(emp.getEmpPassword());
		this.setEmpUsername(emp.getEmpUsername());
		System.out.println(emp.getEmpUsername()+" XXX "+emp.getEmpPassword());
	}
	
	@Override
	public String getPassword() {

		return null;
	}

	@Override
	public String getUsername() {

		return null;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}

package com.coderscampus.HotStonePOS.security;


import org.springframework.security.core.userdetails.UserDetails;

import com.coderscampus.HotStonePOS.domain.Employee;


public class CustomSecurityEmp extends Employee implements UserDetails {

	private static final long serialVersionUID = 1L;

	public CustomSecurityEmp(){} //Spring Req.
	
	public CustomSecurityEmp(Employee emp) {
		this.setAuthorities(emp.getAuthorities());
		this.setId(emp.getId());
		this.setPassword(emp.getPassword());
		this.setUsername(emp.getUsername());
		this.setTitle(emp.getTitle());
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

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
		
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

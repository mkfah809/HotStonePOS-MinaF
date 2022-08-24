package com.coderscampus.HotStonePOS.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "authorities")
public class Authorities implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	private Long authId;
	private String authority;
	private Employee emp;

	@ManyToOne
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	private Employee employee;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return authId;
	}

	public void setId(Long id) {
		this.authId = id;
	}

	@ManyToOne()
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}

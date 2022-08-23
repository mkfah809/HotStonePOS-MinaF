package com.coderscampus.HotStonePOS.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "employees")
public class Employee{
	private Long empId;
	private String empTitle;
	private String empUsername;
	private String empPassword;
	private List<Order> orders;
	private Set<Authority> authorities = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employee")
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public String getEmpUsername() {
		return empUsername;
	}

	public void setEmpUsername(String empUsername) {
		this.empUsername = empUsername;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	@JoinTable(name = "emp_order", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}

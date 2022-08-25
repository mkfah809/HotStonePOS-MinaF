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
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee{
	private Long id;
	private String title;
	private String username;
	private String password;
	private List<Order> orders;
	private Set<Authority> authorities = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "emp")
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getEmpId() {
		return id;
	}

	public void setEmpId(Long empId) {
		this.id = empId;
	}

	public String getEmpTitle() {
		return title;
	}

	public void setEmpTitle(String empTitle) {
		this.title = empTitle;
	}

	public String getEmpUsername() {
		return username;
	}

	public void setEmpUsername(String empUsername) {
		this.username = empUsername;
	}

	public String getEmpPassword() {
		return password;
	}

	public void setEmpPassword(String empPassword) {
		this.password = empPassword;
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

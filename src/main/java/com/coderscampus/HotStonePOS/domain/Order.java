package com.coderscampus.HotStonePOS.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "orders")
public class Order {
	private Long orderId;
	private String orderType;
	private String orderDiscount;
	private String orderComment;
	private Boolean orderStatus;
	private List<Employee> employees;
	private List<Customer> customers;

	@ManyToMany(mappedBy = "orders", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(String orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public String getOrderComment() {
		return orderComment;
	}

	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	@ManyToMany(mappedBy = "orders", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	public List<Employee> getEmployee() {
		return employees;
	}

	public void setEmployee(List<Employee> employee) {
		this.employees = employee;
	}

}

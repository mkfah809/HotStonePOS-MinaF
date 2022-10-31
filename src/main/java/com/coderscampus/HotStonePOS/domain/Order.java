package com.coderscampus.HotStonePOS.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "orders")
@Entity
public class Order {
	private Long id;
	private String type;
	private String discount;
	private String comment;
	private Boolean isPaid;
	private Employee emp;
	
	
	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

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
	public Long getId() {
		return id;
	}

	public void setId(Long orderId) {
		this.id = orderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String orderType) {
		this.type = orderType;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String orderDiscount) {
		this.discount = orderDiscount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String orderComment) {
		this.comment = orderComment;
	}



}

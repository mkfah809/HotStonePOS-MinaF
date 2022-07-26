package com.coderscampus.HotStonePOS.domain;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "orders")
@Entity
public class Order {
	private Long id;
	private String type;
	private String discount;
	public Double finalPrice;

	private String comment;
	private Boolean isPaid;
	private Employee emp;
	private Customer cust;
	private List<Pizza> pizzas = new ArrayList<>();

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "order_has_pizzas", joinColumns = @JoinColumn(name = "order_id"), inverseJoinColumns = @JoinColumn(name = "pizza_id"))
	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	@ManyToOne
	@JoinColumn(name = "cust_id")
	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@ManyToOne
	@JoinColumn(name = "emp_id")
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
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

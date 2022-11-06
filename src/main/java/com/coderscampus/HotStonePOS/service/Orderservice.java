package com.coderscampus.HotStonePOS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.domain.Order;
import com.coderscampus.HotStonePOS.domain.Pizza;
import com.coderscampus.HotStonePOS.repository.EmployeeRepository;
import com.coderscampus.HotStonePOS.repository.OrderRepository;
import com.coderscampus.HotStonePOS.repository.PizzaRepository;

@Service
public class Orderservice {

	@Autowired
	OrderRepository orderRepo;
	@Autowired
	PizzaRepository pizzaRepo;

	@Autowired
	CustomerService custService;
	@Autowired
	empDetailsServiceImpl empService;

	public Order findById(Long custId) {
		return orderRepo.findById(custId).orElse(null);
	}

	public Order save(Order order, Employee emp, Customer cust, List<Order> orders) {
		if (order.getId() == null) {
			setEmployeeToOrder(order, emp, orders);
			setCustomerToOrder(order, cust, orders);
		}
		return orderRepo.save(order);
	}

	public void setEmployeeToOrder(Order order, Employee emp, List<Order> orders) {
		orders.add(order);
		order.setEmp(emp);
		emp.setOrders(orders);
	}

	public void setCustomerToOrder(Order order, Customer cust, List<Order> orders) {
		orders.add(order);
		order.setCust(cust);
		cust.setOrders(orders);

	}

	public void setPizzaToOrder(Pizza pizza, ArrayList<Pizza> pizzas, List<Order> orders, Order order) {
		order.setPizzas(pizzas);
		order.getPizzas().add(pizza);
		pizza.getOrders().add(order);
		pizzaRepo.save(pizza);
	}

	public void setToppingToPizza() {

	}

}

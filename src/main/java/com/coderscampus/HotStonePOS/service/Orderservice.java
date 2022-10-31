package com.coderscampus.HotStonePOS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.domain.Order;
import com.coderscampus.HotStonePOS.repository.EmployeeRepository;
import com.coderscampus.HotStonePOS.repository.OrderRepository;

@Service
public class Orderservice {

	@Autowired

	OrderRepository orderRepo;
	@Autowired
	CustomerService custService;

	@Autowired
	empDetailsServiceImpl empService;

	public Order findById(Long custId) {
		return orderRepo.findById(custId).orElse(null);
	}

	public Order save(Order order) {
		return orderRepo.save(order);
	}

	public void setEmployeeToOrder(Order order, Employee emp) {
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		order.setEmp(emp);
		emp.setOrders(orders);
	}
}

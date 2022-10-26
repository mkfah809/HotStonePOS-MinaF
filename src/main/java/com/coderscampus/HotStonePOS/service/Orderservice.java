package com.coderscampus.HotStonePOS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.domain.Order;
import com.coderscampus.HotStonePOS.repository.OrderRepository;

@Service
public class Orderservice {

	@Autowired
	OrderRepository orderRepo;

	public Order findById(Long custId) {
		return orderRepo.findById(custId).orElse(null);
	}

	public void setEmployeeToOrder(Order order, Employee emp) {

	}

	public void setCustomerToOrder(Order order, Customer cust) {

	}

	public Order save(Order order) {

		return orderRepo.save(order);

	}
}

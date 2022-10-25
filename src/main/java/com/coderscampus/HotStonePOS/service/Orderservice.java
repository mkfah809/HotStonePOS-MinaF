package com.coderscampus.HotStonePOS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Order;
import com.coderscampus.HotStonePOS.repository.OrderRepository;

@Service
public class Orderservice {

	@Autowired
	OrderRepository orderRepo;
	
	public Order findById(Long custId) {
		return orderRepo.findById(custId).orElse(null);
	}
}

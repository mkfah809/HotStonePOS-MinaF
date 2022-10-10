package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderscampus.HotStonePOS.domain.Address;
import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.service.CustomerService;

@Controller

public class CustomerController {
	
	@Autowired
	CustomerService custService;

	@GetMapping("customer/information/")
	public String getCustomer(ModelMap model) {
		model.put("customer", new Customer());
		return "customer";
	}

	@PostMapping("customer/information/")
	public String postCustomer(@RequestBody Customer cust) {
		custService.save(cust);
		return "redirect:/customer/information/";
	}
}

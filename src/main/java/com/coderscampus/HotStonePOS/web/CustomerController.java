package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.HotStonePOS.domain.Address;
import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService custService;

	@GetMapping("/customer/information/new")
	public String getCustomer(ModelMap model) {
		model.put("customer", new Customer());
		return "searchCustomer";
	}

	@PostMapping("/customer/information/new")
	public String postCustomer(Customer cust) throws Exception {
		Customer foundByPhone = custService.findByPhone(cust.getPhone());

		if (foundByPhone != null) {
		} else {
			custService.save(cust);
			return "redirect:/customer/information/" + custService.findByPhone(cust.getPhone()).getCustId();

		}

		return "redirect:/customer/information/" + foundByPhone.getCustId();
	}

	@GetMapping("/customer/information/{custId}")
	String getExistingCustomer(@PathVariable Long custId, ModelMap model) {
		if (custId != null) {
			Customer findById = custService.findById(custId);
			model.put("customer", findById);
		}
		return "customer";
	}

	@PostMapping("/customer/information/{custId}")
	String updateExistingCustomer(Customer cust, ModelMap model) {
		System.out.println("Updating Customer# " + cust.getCustId());
		custService.setAddressToCustomer(cust, new Address());
		custService.save(cust);

		return "redirect:/customer/information/" + cust.getCustId();
	}

}

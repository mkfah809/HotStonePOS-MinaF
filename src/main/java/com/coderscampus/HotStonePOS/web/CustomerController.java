package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
		
		if (foundByPhone == null) {
			custService.save(cust);
			return "redirect:/customer/information/new";
		}

		return "redirect:/customer/information/" + foundByPhone.getCustId();
	}

	@GetMapping("/customer/information/{custId}")
	String getExistingCustomer(@PathVariable Long custId, ModelMap model) {
		Customer findById = custService.findById(custId);
		model.put("customer", findById);
		return "customer";
	}

	@PostMapping("/customer/information/{custId}")
	String updateExistingCustomer(@RequestBody Customer cust, ModelMap model) {
		Customer foundByPhone = custService.findByPhone(cust.getPhone());
		custService.save(foundByPhone);
		custService.setAddressToCustomer(foundByPhone, new Address());

		return "redirect:/customer/information/" + foundByPhone.getCustId();
	}

}

package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.HotStonePOS.domain.Address;
import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService custService;

	@GetMapping("/customer/information/")
	public String getCustomer(ModelMap model ) {
		model.put("customer", new Customer());
		return "customer";
	}

	@PostMapping("/customer/information/")
//	@ResponseBody
	public String postCustomer(@RequestBody Customer cust, ModelMap model) {
		Customer foundByPhone = custService.findByPhone(cust.getPhone());
		if (foundByPhone == null) {
			custService.save(cust);
			return "/customer/information/";
		}
		
		System.out.println("XXXX " + foundByPhone.getCustId());
		System.out.println("XXXX " + foundByPhone.getName());
		System.out.println("XXXX " + foundByPhone.getPhone());

		model.put("customer",foundByPhone);
		return "redirect:/customer/information/"+foundByPhone.getCustId();
	}

//	@GetMapping("/customer/information/{custId}")
//	public String getExistingCustomer(@PathVariable Long custId, ModelMap model) {
//		Customer foundById = custService.findById(custId);
//		System.out.println("XXXX " + foundById.getCustId());
//		System.out.println("XXXX " + foundById.getName());
//		System.out.println("XXXX " + foundById.getPhone());
//		model.put("customer", foundById);
//		return "customer";
//	}

}

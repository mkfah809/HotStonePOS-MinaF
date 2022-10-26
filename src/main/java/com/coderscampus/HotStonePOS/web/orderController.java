package com.coderscampus.HotStonePOS.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.domain.Order;
import com.coderscampus.HotStonePOS.service.CustomerService;
import com.coderscampus.HotStonePOS.service.Orderservice;

@Controller
public class orderController {
	@Autowired
	Orderservice orderService;
	@Autowired
	CustomerService custService;


	@GetMapping("/order/here/{custId}")
	public String getOrder(@PathVariable Long custId, @AuthenticationPrincipal Employee emp, ModelMap model,
			Order order) {
		System.out.println("cust# is " + custId);
		if (custId != null) {

			model.put("customer", custService.findById(custId));
			model.put("employee", emp);
		}
		return "order";
	}

	@PostMapping("/order/here/{custId}")
	public String postNewOrder(Order order, @AuthenticationPrincipal Employee emp) {
		Order orderSaved = orderService.save(order);
		orderService.setEmployeeToOrder(order, emp);
//		orderService.setCustomerToOrder(orderSaved, custService.findById(custId));
		return "redirect:/order/here/{custId}/for/" + orderSaved.getOrderId();
	}
}

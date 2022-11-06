package com.coderscampus.HotStonePOS.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.HotStonePOS.domain.Customer;
import com.coderscampus.HotStonePOS.domain.Employee;
import com.coderscampus.HotStonePOS.domain.Order;
import com.coderscampus.HotStonePOS.domain.Pizza;
import com.coderscampus.HotStonePOS.service.CustomerService;
import com.coderscampus.HotStonePOS.service.Orderservice;
import com.coderscampus.HotStonePOS.service.PizzaService;

@Controller
public class orderController {
	@Autowired
	Orderservice orderService;
	@Autowired
	CustomerService custService;
	@Autowired
	PizzaService pizzaService;
	
	@GetMapping("/order/here/{custId}")
	public String getNewOrder(@PathVariable Long custId, @AuthenticationPrincipal Employee emp, ModelMap model,
			Order order) {
		if (custId != null) {
			model.put("pizza", new Pizza());
			model.put("customer", custService.findById(custId));
			model.put("employee", emp);
		}
		return "order";
	}

	@PostMapping("/order/here/{custId}")
	public String postNewOrder(ArrayList<Order> orders, Order order, @AuthenticationPrincipal Employee emp,
			Customer cust, ArrayList<Pizza> pizzas, Pizza pizza) {
		pizzas.add(pizza);
		pizzaService.save(pizza);
		pizzaService.saveAll(pizzas);
//		orderService.save(order, emp, custService.findById(cust.getCustId()), orders);		
//		orderService.setPizzaToOrder(pizza, pizzas, orders, order);
		return "redirect:/dashboard";
	}

//	@GetMapping("/order/here/{custId}/{orderId}")
//	public String getExistingOrder(@PathVariable Long orderId, @PathVariable Long custId, ModelMap model, Pizza pizza) {
//		
//		model.put("order", orderService.findById(orderId));
//		return "redirect:/dashboard";
//	}

}

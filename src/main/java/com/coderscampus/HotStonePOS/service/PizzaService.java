package com.coderscampus.HotStonePOS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.HotStonePOS.domain.Pizza;
import com.coderscampus.HotStonePOS.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	PizzaRepository pizzaRepo;
	public Pizza save(Pizza pizza) {
		return pizzaRepo.save(pizza);
		
	}
	public List<Pizza> saveAll(List<Pizza> pizzas) {
		return pizzaRepo.saveAll(pizzas);
		
	}

}

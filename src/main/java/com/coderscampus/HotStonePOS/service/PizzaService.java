package com.coderscampus.HotStonePOS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.coderscampus.HotStonePOS.domain.Pizza;
import com.coderscampus.HotStonePOS.repository.PizzaRepository;

@Service
public class PizzaService {

	@Autowired
	PizzaRepository pizzaRepo;

	public Pizza save(Pizza pizza) {
		return pizzaRepo.save(pizza);

	}

	public void delete(Long pizzaId) {
		pizzaRepo.deleteById(pizzaId);
	}

	public List<Pizza> findAll() {
		return pizzaRepo.findAll();
	}

	public Pizza findById(Long id) {
		return pizzaRepo.findById(id).orElse(null);
	}

	public List<Pizza> findAllByOrder(Long orderId) {
		return pizzaRepo.findAllByOrder(orderId);

	}

	public Double setPriceToPizza(Pizza pizza, Double pizzaPrice) {
		if (pizza.getSize().equalsIgnoreCase("LG")) {
			pizza.setPrice(11.99);
		} else {
			pizza.setPrice(08.99);
		}

		return pizzaPrice = pizza.getQty() * pizza.getPrice();
	}

	public Iterable<Pizza> saveAll(List<Pizza> pizzas) {
		return pizzaRepo.saveAll(pizzas);
	}

	public Double setPriceToItem(Double price, List<Pizza> findAllByOrder,
			List<Double> priceForAllItems) {
		for (Pizza pizza : findAllByOrder) {
			price = pizza.getPrice();
			priceForAllItems.add(price);
		}
		return price;
	}

}

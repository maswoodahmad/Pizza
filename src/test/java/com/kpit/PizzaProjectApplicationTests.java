package com.kpit;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpit.layer2.Pizza;
import com.kpit.layer3.PizzaNotFoundException;
import com.kpit.layer3.PizzaRepository;

@SpringBootTest
class PizzaProjectApplicationTests { //BELOW ALL TESTs are OF DATABASE

	
	//ALL THE TEST CASES BELOW ARE OF REPOSITORY TESTING
	
	@Autowired
	PizzaRepository pizzaRepository; //auto injection done by spring  since @Autowired is there
	
	@Test
	void loadAllPizzasTest() {
		
		List<Pizza> pizzaList = pizzaRepository.findAll();
		for (Pizza pizza : pizzaList) {
			System.out.println("PIZZA ID   : "+pizza.getPizzaId());
			System.out.println("PIZZA TYPE : "+pizza.getPizzaType());
			System.out.println("PIZZA COST : "+pizza.getPizzaPrice());
			System.out.println("---------------");
		}
		
	}
	
	@Test
	void loadAPizzaByIdTest() {
		
		int pizzaIdToFind=1;
		Optional<Pizza> pizza = pizzaRepository.findById(pizzaIdToFind);
		
		if(pizza.isPresent()) {
			Pizza pizzaObj = pizza.get();
		
			System.out.println("PIZZA ID   : "+pizzaObj.getPizzaId());
			System.out.println("PIZZA TYPE : "+pizzaObj.getPizzaType());
			System.out.println("PIZZA COST : "+pizzaObj.getPizzaPrice());
			System.out.println("---------------");
		}
		else {
			//throw exception
			throw new PizzaNotFoundException("Pizza with id "+ pizzaIdToFind +" not found");
			
		}
		
	}

	
	@Test
	void modifyPizzaTest() {
		
		Pizza modifiedPizza = new Pizza();
		modifiedPizza.setPizzaId(1);
		modifiedPizza.setPizzaType("Cheese Corn Pizza");
		modifiedPizza.setPizzaPrice(300);
		
		pizzaRepository.save(modifiedPizza);
	}
	
	
	@Test
	void createPizzaTest() {
		
		Pizza newPizza = new Pizza();
		newPizza.setPizzaId(6);
		newPizza.setPizzaType("Extravaganza Pizza");
		newPizza.setPizzaPrice(500);
		
		pizzaRepository.save(newPizza);
	}
	
	@Test
	void removePizzaTest() {
		
		Pizza pizzaToDelete = new Pizza();
		pizzaToDelete.setPizzaId(4);
		
		pizzaRepository.delete(pizzaToDelete);
	}
	
}

package com.kpit;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kpit.layer2.Pizza;
import com.kpit.layer3.PizzaAlreadyExistException;
import com.kpit.layer4.PizzaService;

@SpringBootTest
public class PizzaServiceTesting {


	//ALL THE TEST CASES BELOW ARE OF SERVICE TESTING

	@Autowired
	PizzaService pizzaService;

	@Test
	public void findASinglePizzaServiceTest() {
		
		Pizza pizza = pizzaService.orderingAPizza(1);
		System.out.println("Pizza id    : "+pizza.getPizzaId());
		System.out.println("Pizza type  : "+pizza.getPizzaType());
		System.out.println("Pizza price : "+pizza.getPizzaPrice());
		
		
	}
	
	@Test
	public void findAllPizzas() {
		List<Pizza> pizzas = pizzaService.getAllPizzas();
		for (Pizza pizza : pizzas) {
			System.out.println("Pizza id    : "+pizza.getPizzaId());
			System.out.println("Pizza type  : "+pizza.getPizzaType());
			System.out.println("Pizza price : "+pizza.getPizzaPrice());
			System.out.println("-----------");
		}
	}
	
	@Test
	public void createPizzaTest() throws PizzaAlreadyExistException
	{	
		Pizza newPizza = new Pizza();
		newPizza.setPizzaId(7);
		newPizza.setPizzaType("Shravan Pizza");
		newPizza.setPizzaPrice(240);
			
		pizzaService.createPizza(newPizza);
		System.out.println("Pizza created...");
	}
	
	@Test
	public void modifyPizzaTest() 
	{	
		Pizza pizzaToModify = new Pizza();
		pizzaToModify.setPizzaId(7);
		pizzaToModify.setPizzaType("CHICKEN Pizza");
		pizzaToModify.setPizzaPrice(340);
			
		pizzaService.modifyPizza(pizzaToModify);
		System.out.println("Pizza modified...");
	}
	
	@Test
	public void deletePizzaTest() 
	{	

		pizzaService.deletePizza(7);
		System.out.println("Pizza deleted...");
	}
}

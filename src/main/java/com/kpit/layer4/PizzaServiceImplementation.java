package com.kpit.layer4;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpit.layer2.Pizza;
import com.kpit.layer3.PizzaAlreadyExistException;
import com.kpit.layer3.PizzaNotFoundException;
import com.kpit.layer3.PizzaRepository;

@Service // required 
public class PizzaServiceImplementation implements PizzaService {

	@Autowired
	PizzaRepository pizzaRepository; //IS IT TESTED OK1 OK2 OK3 OK4 OK5
	
	public PizzaServiceImplementation() {
		System.out.println("PizzaServiceImplementation()....");
	}
	
	public List<Pizza> getAllPizzas() {
		return pizzaRepository.findAll();
	}


	@Override
	public Pizza orderingAPizza(int id) { //SERVICE MAN
		Pizza pizzaObj = null;
		
										//THE CHEF
		Optional<Pizza> foundPizza = pizzaRepository.findById(id);
		if(foundPizza.isPresent()) {
			pizzaObj = foundPizza.get(); //retrieve it from the DB 
			pizzaObj.setPizzaType(pizzaObj.getPizzaType()+" more cheese added with little extra spices");
		}
		return pizzaObj;
	}

	@Override
	public void createPizza(Pizza pizza) throws PizzaAlreadyExistException
	{

		Pizza pizzaObj = null;
		Optional<Pizza> foundPizza = pizzaRepository.findById(pizza.getPizzaId());
		if(foundPizza.isPresent()) {
			pizzaObj = foundPizza.get(); //retrieve it from the DB 
			throw new PizzaAlreadyExistException("Pizza with id alreayd exists : "+pizza.getPizzaId());
		}
		else {
			pizzaRepository.save(pizza);
			System.out.println("Pizza SAVED");
		}
	}

	@Override
	public Pizza modifyPizza(Pizza pizza) {
		Optional<Pizza> foundPizza = pizzaRepository.findById(pizza.getPizzaId());
		if(foundPizza.isPresent()) {
			pizzaRepository.save(pizza);
			System.out.println("Pizza MODIFIED");
			
		}
		else {
			throw new PizzaNotFoundException("Pizza with Id not found : "+pizza.getPizzaId());
		}
		
		return pizza;
	}

	@Override
	public void deletePizza(int id) {
		Pizza pizzaToDelete = null;
		
		Optional<Pizza> foundPizza = pizzaRepository.findById(id);
		if(foundPizza.isPresent()) {
			pizzaToDelete = foundPizza.get(); //retrieve it from the DB 
			pizzaRepository.delete(pizzaToDelete);
			System.out.println("Pizza DELETED");
			
		}
		else {
			throw new PizzaNotFoundException("Pizza with Id not found : "+id);
		}
		
	}

}

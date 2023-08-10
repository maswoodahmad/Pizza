package com.kpit.layer5;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpit.layer2.Pizza;
import com.kpit.layer3.PizzaAlreadyExistException;
import com.kpit.layer3.PizzaNotFoundException;
import com.kpit.layer4.PizzaService;

@RestController
@RequestMapping("/dominos/")
public class PizzaController {

	@Autowired
	PizzaService pizzaService; //would talk with the chef | PizzaRepository
	
	public PizzaController() {
		System.out.println("PizzaController()");
	}
	
	
	@GetMapping("/getPizza/{id}") //localhost:8080/dominos/getPizza/1
	public Pizza getPizza(@PathVariable("id") Integer pid) {
		System.out.println("Pizza Controller is ordering Pizza from the PizzaService....");
		
		return pizzaService.orderingAPizza(pid);
	}

	//FOR GETTING A RECORD
	@GetMapping("/getPizzas") //localhost:8080/dominos/getPizzas
	public List<Pizza> getPizzas() {
		System.out.println("Pizza Controller is retrieving all Pizzas from the PizzaService....");
		
		return pizzaService.getAllPizzas();
	}
	
	//FOR STORING A RECORD
	@PostMapping("/addPizza") //localhost:8080/dominos/pizzas/addPizza
	public ResponseEntity<String> storeAPizza(@RequestBody Pizza pizza) {
		
		System.out.println("Pizza Controller is storing a pizza...");
		try {
			pizzaService.createPizza(pizza);
			return ResponseEntity.status(HttpStatus.CREATED).body("Pizza SUCCESSFULLY Created");
		} catch (PizzaAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	//FOR UPDATING A RECORD
	@PutMapping("/updatePizza") //localhost:8080/dominos/updatePizza
	public ResponseEntity<String> modifyAPizza(@RequestBody Pizza pizza) {
		
		System.out.println("Pizza Controller is updating a pizza...");
		try {
			pizzaService.modifyPizza(pizza);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pizza SUCCESSFULLY MODIFIED");
		} catch (PizzaNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	//FOR DELETING A RECORD
		@DeleteMapping("/deletePizza/{pid}") //localhost:8080/dominos/updatePizza
		public ResponseEntity<String> removeAPizza(@PathVariable("pid") int pizzaIdToDelete) {
			
			System.out.println("Pizza Controller is updating a pizza...");
			try {
				pizzaService.deletePizza(pizzaIdToDelete);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body("Pizza SUCCESSFULLY DELETED");
			} catch (PizzaNotFoundException e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		}

}

package com.kpit.layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kpit.layer2.Pizza;
import com.kpit.layer3.PizzaAlreadyExistException;

@Service // same as @Component | @Repository
public interface PizzaService {

	Pizza orderingAPizza(int id);
	List<Pizza> getAllPizzas();
	
	void createPizza(Pizza pizza) throws PizzaAlreadyExistException;
	Pizza modifyPizza(Pizza pizza);
	void  deletePizza(int id);

}

package com.kpit.layer2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PIZZA") //real table's name
public class Pizza { //<-- YOUR POJO 

	@Id //<--marked as primay key
	@Column(name="pizzaid") //actual table column's name
	private int pizzaId;

	@Column(name="pizzatype") //actual table column's name
	private String pizzaType;
	
	@Column(name="pizzaprice") //<-actual table column's name
	private float pizzaPrice;
	
	public Pizza() {
		System.out.println("Pizza() constructor....");
	}
	//generate all the setters/getters
	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getPizzaType() {
		return pizzaType;
	}

	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}

	public float getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(float pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	
}

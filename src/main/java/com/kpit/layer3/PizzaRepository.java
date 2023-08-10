package com.kpit.layer3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpit.layer2.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {

	//seen as empty as of now
	//but super interface functions are here too
}

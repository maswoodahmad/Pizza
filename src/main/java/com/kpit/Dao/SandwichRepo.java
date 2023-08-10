package com.kpit.Dao;

import com.kpit.layer2.Sandwich;
import org.springframework.data.repository.CrudRepository;



public interface SandwichRepo extends CrudRepository<Sandwich, Integer> {

    public Sandwich findById(int id);
}

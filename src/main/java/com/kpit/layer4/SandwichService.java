package com.kpit.layer4;

import com.kpit.Dao.SandwichRepo;
import com.kpit.layer2.Sandwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;
@Component
public class SandwichService {

@Autowired
private SandwichRepo sandwichRepo;

    public Sandwich getASandwich(int id)
    {
         return this.sandwichRepo.findById(id);
    }

    public List<Sandwich> getAllSandwich()
    {
        return  (List<Sandwich>)this.sandwichRepo.findAll();
    }

    public void modifySandwich( Sandwich sandwich){

        this.sandwichRepo.save(sandwich);
    }

    public void deleteASandwich(int id)
    {
        this.sandwichRepo.deleteById(id);
    }


    public void addASandwich(Sandwich sand){
        sandwichRepo.save(sand);
    }

}

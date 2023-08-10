package com.kpit.layer5;

import com.kpit.layer2.Sandwich;
import com.kpit.layer3.PizzaNotFoundException;
import com.kpit.layer3.SanwichAlreadyFoundException;
import com.kpit.layer4.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SandwichController {
@Autowired
    private SandwichService sandwichService;

    @GetMapping("/sandwich")
    public ResponseEntity<List<Sandwich>> getAllSandwichs(){
        System.out.println("in the store");
    List<Sandwich> list = sandwichService.getAllSandwich();
    if(list==null)
    {
        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry!! no sandwhich is in the store");

    }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }


    @GetMapping("/sandwich/{id}")
    public ResponseEntity<Sandwich> getASandwichs(@PathVariable("id") int id){
        System.out.println("getting a sandwich");
  if(sandwichService.getASandwich(id)!=null) {
      return ResponseEntity.status(HttpStatus.OK).body(sandwichService.getASandwich(id));

  }
  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }


    @PostMapping("/add-sandwich")
    public ResponseEntity<String> addASandwich(@RequestBody Sandwich sanwich)
    {
        System.out.println(sandwichService);


      if(sandwichService.getASandwich(sanwich.getId())==null)
      {
          System.out.println("here ");
          sandwichService.addASandwich(sanwich);
          return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sandwich SUCCESSFULLY created");

      }
      return  ResponseEntity.ok().body("sandwich already exist try adding diffrent sandwich");

    }

    @PutMapping("/modify-sandwich")
    public ResponseEntity<String> modifySandwich(@RequestBody Sandwich sandwich)
    {
        System.out.println("in here in modify");
        if(sandwichService.getASandwich(sandwich.getId())!=null)
        {
            sandwichService.modifySandwich(sandwich);
            return ResponseEntity.status(HttpStatus.OK).body("SUCCESSFULLY modified");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("delete-a-sanwich/{id}")
    public ResponseEntity<String> deleteASandwich(@PathVariable("id") int id )
    {
        if(sandwichService.getASandwich(id)!=null)
        {
            sandwichService.deleteASandwich(id);
            return ResponseEntity.status(HttpStatus.OK).body("Sucessfully! deleted");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Sandwich might not found or error");
    }



}

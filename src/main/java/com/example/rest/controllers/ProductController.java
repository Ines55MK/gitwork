package com.example.rest.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entities.Product;
import com.example.rest.repositories.Productrepository;


@RestController
@RequestMapping("product")  
public class ProductController {

    private Productrepository productrepository;

    
    public ProductController(Productrepository productrepository) {
        this.productrepository = productrepository;
    }

    @GetMapping
    public List<Product> afficher() {
        return productrepository.findAll();
    }

    @PostMapping
    public Product ajouterProduct(@RequestBody Product product) {
        return productrepository.save(product);
    }
   @DeleteMapping("{id}")
   public void delete (@PathVariable("id") long id)
   {
	   productrepository.deleteById(id);
   }
  @PutMapping("{id}")
  public Product modifier(@PathVariable("id")long id,@RequestBody Product product) {
	 
	Product p=productrepository.getById(id);
	  p.setName(product.getName());
	  p.setPrice(product.getPrice());
	  return p;
  }
  
  
  
  
  
  
  
}
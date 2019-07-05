package com.example.poc.Digital_01.Controller;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.Finishings;
import javax.validation.Valid;

import org.aspectj.lang.annotation.RequiredTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.Digital_01.Service.Product_Service;
import com.example.poc.Digital_01.model.Product;

import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/products")
@Slf4j
public class Product_Controller {
	Logger log =LoggerFactory.getLogger(Product_Controller.class);
	@Autowired
	public Product_Service ps;
    @GetMapping
	public List<Product> getProduct(){
		return ps.findAll();
    }
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(ps.save(product));
    }
	  
     @GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id)
	{
		Optional<Product> stock=ps.findById(id);
		if(!stock.isPresent()) {
			log.error("Id "+id+" not existed");
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(stock.get());
	}
	
     @PutMapping("/{id}")
     public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product)
     {
    	 Optional<Product> stock=ps.findById(id);
    	 if(!stock.isPresent()) {
    		 log.error("Id "+id+" not existed");
    		   ResponseEntity.badRequest().build();
    	 }else {
    		 product.setId(id);
        	 return ResponseEntity.ok(ps.save(product));
		}
    	 return null;
     }
     @DeleteMapping("/{id}")
     public ResponseEntity delete(@PathVariable Long id)
     {
    	 if (!ps.findById(id).isPresent()) {
             log.error("Id " + id + " is not existed");
             ResponseEntity.badRequest().build();
         }
    	 ps.deleteById(id);
    	 return ResponseEntity.ok().build();
     }
}

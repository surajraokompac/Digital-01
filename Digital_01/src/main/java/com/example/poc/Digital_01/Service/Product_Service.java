package com.example.poc.Digital_01.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.poc.Digital_01.Repository.ProductRepository; 	
import com.example.poc.Digital_01.model.Product;
@Service
public class Product_Service {
	@Autowired
    private ProductRepository pr;

    public List<Product> findAll() {
        return pr.findAll();
    }

    public Optional<Product> findById(Long id) {
        return pr.findById(id);
    }

    public Product save(Product stock) {
        return pr.save(stock);
    }

    public void deleteById(Long id) {
    	pr.deleteById(id);
    }

	public Object save(Optional<Product> stock) {
		// TODO Auto-generated method stub
		return null;
	}
}
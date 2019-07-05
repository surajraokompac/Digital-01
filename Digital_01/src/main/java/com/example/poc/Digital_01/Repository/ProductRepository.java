package com.example.poc.Digital_01.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.poc.Digital_01.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>
{
	

}

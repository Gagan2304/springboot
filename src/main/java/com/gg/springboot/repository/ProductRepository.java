package com.gg.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gg.springboot.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}

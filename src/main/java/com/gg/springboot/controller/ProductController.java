package com.gg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gg.springboot.exception.ResourceNotFoundException;
import com.gg.springboot.model.Product;
import com.gg.springboot.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	//Get List of all products
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
		
	}
	
	//Get product by Id
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not exsist with id : " +id));
		return product;
		
		
	}
	
	//Adding new Products
	
	@PostMapping("/newProduct")
	public Product addNewProduct(@RequestBody Product product) {
		return productRepository.save(product);
		
	}
	
	//Update the product
	
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		Product newproduct = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not exsist with id : " +id));
		newproduct.setpName(product.getpName());
		newproduct.setpCatagory(product.getpCatagory());
		newproduct.setpPrice(product.getpPrice());
		
		Product updatedProduct = productRepository.save(newproduct);
		return updatedProduct;
		
	}
	
	//Delete the product
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product does not exsist with id : " +id));
		
		productRepository.delete(product);
	
	}
	
	

}

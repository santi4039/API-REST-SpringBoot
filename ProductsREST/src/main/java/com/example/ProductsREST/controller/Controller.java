package com.example.ProductsREST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductsREST.model.Product;
import com.example.ProductsREST.service.product_service;

@RestController
public class Controller {

	
	@Autowired
	private product_service service;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return service.listModels();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		
		try {
			Product product =  service.getProductById(id);
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}catch(Exception excepcion) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@PostMapping("/products")
	public void saveProduct(@RequestBody Product product) {
		service.saveProduct(product);
	}
	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody Product product,@PathVariable Integer id){
		try {
			
			Product Exist_Product = service.getProductById(id);
			
			Exist_Product.setName(Exist_Product.getName());
			Exist_Product.setPrice(Exist_Product.getPrice());
			
			service.saveProduct(Exist_Product);
			
			return new ResponseEntity<Product>(HttpStatus.OK);
		}catch(Exception excepcion) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		service.deleteProductById(id);
	}
	
}

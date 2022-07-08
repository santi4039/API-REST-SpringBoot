package com.example.ProductsREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductsREST.model.Product;
import com.example.ProductsREST.repository.product_repository;

@Service
public class product_service {

	
	@Autowired
	private product_repository repository;
	
	public List<Product> listModels(){
		
		return repository.findAll();
	}
	
	public void saveProduct(Product product) {
		repository.save(product);
	}
	
	
	public Product getProductById(Integer id) {
		return repository.findById(id).get();
	}
	

	public void deleteProductById(Integer id) {
		repository.deleteById(id);
	}
	
}

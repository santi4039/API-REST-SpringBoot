package com.example.ProductsREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductsREST.model.Product;


public interface product_repository extends JpaRepository<Product,Integer> {

}

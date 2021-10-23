package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tcs.beans.Product;
import com.tcs.exception.ProductNotFoundException;
import com.tcs.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductRest {

	@Autowired
	private ProductService service;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@RequestBody Product product) {
		return service.store(product);
	}
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts() {
		return service.fetchProducts();
	}
	// product/1, product/2, product/3
	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> findProduct(@PathVariable("id") int productId) {
		try {
		return new ResponseEntity<Product>(service.fetchProductById(productId),HttpStatus.OK);
	}catch(ProductNotFoundException e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}
	// product/1/15000
	@PutMapping(path = "{id}/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProductPrice(@PathVariable("id") int id, @PathVariable("price") double price) {
		try {
			return new ResponseEntity<Product>(service.updateProductPrice(id, price),HttpStatus.OK);
		}catch(ProductNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	}
	@DeleteMapping(path = "{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		
		
		try {
			service.deleteProductById(id);
			return new ResponseEntity(HttpStatus.OK);
		}catch(ProductNotFoundException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		
	}
	}
}

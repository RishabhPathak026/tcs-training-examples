package com.tcs.service;

import java.util.List;

import com.tcs.beans.Product;

public interface ProductService {
	public Product store(Product product);
	public Product fetchProductById(int productId);
	public void deleteProductById(int productId);
	public Product updateProductPrice(int productId, double price);
	public List<Product> fetchProducts();
}

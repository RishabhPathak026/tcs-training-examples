package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.tcs.beans.Product;
import com.tcs.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	private static List<Product> productsDb = new ArrayList<Product>();

	@Override
	public Product store(Product product) {
		product.setProductId(productsDb.size() + 1);
		productsDb.add(product);
		return product;
	}

	@Override
	public Product fetchProductById(int productId) throws ProductNotFoundException {
		Optional<Product> option = productsDb.stream()
				.filter(product -> product.getProductId() == productId)
				.findAny();
		if(option.isPresent()) {
			return option.get();
		}else {
			 throw new ProductNotFoundException("Sorry "+productId+" not found!");
		}
	}

	@Override
	public void deleteProductById(int productId) throws ProductNotFoundException{
		Product product = fetchProductById(productId);
		if(product != null) {
			productsDb.remove(product);
		}
		throw new ProductNotFoundException("Sorry "+productId+" not found!");
	}

	@Override
	public Product updateProductPrice(int productId, double price) throws ProductNotFoundException{
		
		Product product = fetchProductById(productId);
		if(product != null) {
			product.setPrice(price);
			return product;
		}
		
		throw new ProductNotFoundException("Sorry "+productId+" not found!");
	}

	@Override
	public List<Product> fetchProducts() {
		return productsDb;
	}
	
}

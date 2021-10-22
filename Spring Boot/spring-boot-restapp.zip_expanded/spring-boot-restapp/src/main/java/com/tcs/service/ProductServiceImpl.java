package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.tcs.beans.Product;

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
	public Product fetchProductById(int productId) {
		Optional<Product> option = productsDb.stream()
				.filter(product -> product.getProductId() == productId)
				.findAny();
		return option.orElse(null);
	}

	@Override
	public void deleteProductById(int productId) {
		Product product = fetchProductById(productId);
		if(product != null) {
			productsDb.remove(product);
		}
	}

	@Override
	public Product updateProductPrice(int productId, double price) {
		Product product = fetchProductById(productId);
		if(product != null) {
			product.setPrice(price);
			return product;
		}
		return null;
	}

	@Override
	public List<Product> fetchProducts() {
		return productsDb;
	}
	
}

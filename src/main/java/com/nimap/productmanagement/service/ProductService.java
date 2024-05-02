package com.nimap.productmanagement.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.productmanagement.entity.Category;
import com.nimap.productmanagement.entity.Product;
import com.nimap.productmanagement.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public String addProduct(Product p) {
		String msg= repository.addProduct(p);
		if(Objects.isNull(msg)) {
			msg="Product is not be Added...";
		}
		return msg;
	}
	
	public String deleteProduct(int id) {
		String msg = repository.deleteProduct(id);
		if(Objects.isNull(msg)) {
			msg = "Product Data is Not Deleted";
		}
		return msg;
	}
	
	public String updateProduct(int id,Product p) {
		String msg = repository.updateProduct(id,p);
		if(Objects.isNull(msg)) {
			msg = "Product Data is Not Updated";
		}
		return msg;
	}
	
	public Product getParticularProduct(int id) {
		Product product  = repository.getParticularProduct(id);
		return product;
	}
	
	public List<Product> getAllProduct() {
		List<Product> product = repository.getAllProduct();
		return product;
	}
}

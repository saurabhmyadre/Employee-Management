package com.nimap.productmanagement.controller;

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

import com.nimap.productmanagement.entity.Category;
import com.nimap.productmanagement.entity.Product;
import com.nimap.productmanagement.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product p) {
		String msg= service.addProduct(p);
		return msg;
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		String msg = service.deleteProduct(id);
		return msg;
	}
	
	@PutMapping("/updateproduct/{id}")
	public String updateProduct(@PathVariable int id,@RequestBody Product p) {
		String msg = service.updateProduct(id,p);
		return msg;
	}
	
	
	@GetMapping("/getparticularproduct/{id}")
	public Product getParticularRecord(@PathVariable int id) {
		Product product = service.getParticularProduct(id);
		return product;
	}
	
	@GetMapping("/getallproduct")
	public List<Product> getAllProduct() {
		List<Product> product = service.getAllProduct();
		return product;
	}
}

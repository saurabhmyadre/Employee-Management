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
import com.nimap.productmanagement.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@PostMapping("/addcategory")
	public String addCategory(@RequestBody Category c) {
		String msg = service.addCategory(c);
		return msg;
	}
	
	@DeleteMapping("/deletecategory/{categoryid}")
	public String deleteCategory(@PathVariable int categoryid) {
		String msg = service.deleteCategory(categoryid);
		return msg;
	}
	
	@PutMapping("/updatecategory/{categoryid}")
	public String updateCategory(@PathVariable int categoryid,@RequestBody Category c) {
		String msg = service.updateData(categoryid,c);
		return msg;
	}
	
	
	@GetMapping("/getparticularcategory/{id}")
	public Category getparticularData(@PathVariable int id) {
		Category c = service.getpartcularData(id);
		
		return c;
	}
	
	@GetMapping("/getallcategory")
	public List<Category> getAllData() {
		List<Category> c = service.getAllData();
		return c;
	}
}

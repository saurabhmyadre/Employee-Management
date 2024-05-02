package com.nimap.productmanagement.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.productmanagement.entity.Category;
import com.nimap.productmanagement.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;
	
	public String addCategory(Category category) {
		String msg = repository.addCategory(category);
		if(Objects.isNull(msg)) {
			msg = "Category Data is Not Save";
		}
		return msg;
	}
	
	public String deleteCategory(int categoryid) {
		String msg = repository.deleteCategory(categoryid);
		if(Objects.isNull(msg)) {
			msg = "Category Data is Not Delete";
		}
		return msg;
	}
	
	public String updateData(int categoryid, Category c) {
		String msg = repository.updateCategory(categoryid,c);
		if(Objects.isNull(msg)) {
			msg = "Category Data is Not Upadate";
		}
		return msg;
	}
	
	public Category getpartcularData(int id) {
		Category c = repository.getparticularData(id);
		return c;
	}
	
	public List<Category> getAllData() {
		List<Category> c =repository.getAllData();
		return c;
	}
}

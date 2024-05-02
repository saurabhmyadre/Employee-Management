package com.nimap.productmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String productname;
	
	
	
	public Product() {}

	public Product(int pid, String productname) {
		super();
		this.id = id;
		this.productname = productname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + "]";
	}


	

	

	
	
	
}

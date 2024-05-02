package com.nimap.productmanagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int categoryid;
	
	String productbrand;
	double productprice;
	String status;
	
	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid")
	List<Product> product;
	
	public Category(){}

	public Category(int id, String productbrand, double productprice, String status, List<Product> product) {
		super();
		this.categoryid = id;
		this.productbrand = productbrand;
		this.productprice = productprice;
		this.status = status;
		this.product = product;
	}

	

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getProductbrand() {
		return productbrand;
	}

	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}

	public double getProductprice() {
		return productprice;
	}

	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", productbrand=" + productbrand + ", productprice=" + productprice + ", status="
				+ status + ", product=" + product + "]";
	}
	
	
	
	

	
	
	
}

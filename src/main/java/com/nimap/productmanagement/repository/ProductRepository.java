package com.nimap.productmanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nimap.productmanagement.entity.Category;
import com.nimap.productmanagement.entity.Product;

@Repository
public class ProductRepository {

	@Autowired
	SessionFactory factory;
	
	   // For Add Product Data
		public String addProduct(Product p) {
			
			Session session=null;
			Transaction tx=null;
			String msg=null;
			try {		
			 session= factory.openSession();
			 tx=session.beginTransaction();
			 session.persist(p);
			 tx.commit();
			 msg="Product Added Successfully";
			 }catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return msg;
			}
		
		// For  Delete Product Data
		public String deleteProduct(int id) {
			Session session = null;
			Transaction tx = null;
			String msg = null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				Product product = session.get(Product.class, id);
				session.remove(product);
				tx.commit();
				msg = "Product Deleted Successfully";
			} catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return msg;
		}
		
		 // For Update Product Data
		public String updateProduct(int id,Product p) {
			Session session = null;
			Transaction tx = null;
			String msg =null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				Product product = session.get(Product.class, id);
				product.setProductname(p.getProductname());
				session.merge(product);
				tx.commit();
				msg = "Product Data Updated Successfully";
				} catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return msg;
		}
		
		// For Get Product Particular Data
		public Product getParticularProduct(int id) {
			Session session = null;
			Transaction tx = null;
			Product product = null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				String hqlquery = "from Product where id=:myid";
				Query<Product> p = session.createQuery(hqlquery, Product.class);
				p.setParameter("myid", id);
				product = p.uniqueResult();
				} catch (Exception e1) {
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return product;
		}
		
		// For Get All Product Data
		public List<Product> getAllProduct() {
			Session session = null;
			Transaction tx = null;
			List<Product> product= null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				String hqlquery = "from Product";
				Query<Product> query = session.createQuery(hqlquery, Product.class);
				product = query.list();
				tx.commit();
				} catch (Exception e1) {
				if(tx!=null) {
					tx.rollback();
				}
				e1.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return product;
		}
}

package com.nimap.productmanagement.repository;

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
public class CategoryRepository {

	@Autowired
	SessionFactory factory;
	
	// For Adding Category Data
	 public String addCategory(Category c) {
		Session session=null;
		Transaction tx=null;
		String msg = null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Category Data Added Successfully";
		} catch (Exception e) {
			if(tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return msg;
	}
	
		// For Deleting Category Data
		public String deleteCategory(int categoryid) {
			Session session = null;
			Transaction tx = null;
			String msg = null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				Category category = session.get(Category.class, categoryid);
				session.remove(category);
				tx.commit();
				msg = "Category Data Is Deleted Successfully";
				
			} catch (Exception e) {
				
				e.printStackTrace();
				if(tx!=null) {
					tx.rollback();
				}
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return msg;
		}
		
		// For Updating Category Data
		public String updateCategory(int categoryid, Category c) {
			Session session = null;
			Transaction tx = null;
			String msg = null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				Category category = session.get(Category.class, categoryid);
				category.setProductbrand(c.getProductbrand());
				category.setProductprice(c.getProductprice());
				category.setStatus(c.getStatus());
				session.merge(category);
				tx.commit();
				msg = "Category Data is Updated Successfully";
			} catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return msg;
		}
		
		// For Get Particular Category Data
		public Category getparticularData(int id) {
			Session session =null;
			Transaction tx = null;
			Category category =null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				String hqlQuery = "from Category where id=:myid";
				Query<Category> query = session.createQuery(hqlQuery,Category.class);
				query.setParameter("myid", id);
				category = query.uniqueResult();
				tx.commit();
				} catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return category;
		}
		
		// For Get All Category  Data
		public List<Category> getAllData() {
			Session session =null;
			Transaction tx = null;
			List<Category> category =null;
			try {
				session = factory.openSession();
				tx = session.beginTransaction();
				String hqlQuery = "from Category";
				Query<Category> query = session.createQuery(hqlQuery,Category.class);
				category = query.list();
				  tx.commit();
				} catch (Exception e) {
				if(tx!=null) {
					tx.rollback();
				}
				e.printStackTrace();
			}finally {
				if(session!=null) {
					session.close();
				}
			}
			return category;
		}
}

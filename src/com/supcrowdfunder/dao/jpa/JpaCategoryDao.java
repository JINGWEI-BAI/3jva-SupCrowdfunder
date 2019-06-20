package com.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supcrowdfunder.dao.CategoryDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.Product;

public class JpaCategoryDao implements CategoryDao{

	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaCategoryDao(EntityManagerFactory entityManagerFactory){
        this.myEntityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public Category addCategory(Category category) {
        EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(category);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		return category;
	}

	@Override
	public Category retrieveCategoryById(Long id) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Category category;
		category = em.find(Category.class, id);
		em.close();
		return category;
	}

	@Override
	public List<Category> retrieveAllCategories() {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT c from Category as c");
        List<Category> categories = query.getResultList();
		return categories;
	}

	@Override
	public void removeCategory(Long id) {
		 EntityManager em = myEntityManagerFactory.createEntityManager();
	     EntityTransaction t = em.getTransaction();
	     try{
	      	t.begin();
	      	Category category = em.find(Category.class,id );
	        em.remove(category) ;
	        t.commit();
	     }catch(Exception e){
	      	t.rollback();
	     }finally{
	        em.close();
	     }		
	}

	@Override
	public void updateCategory(Long id, String name) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	Category category = em.find(Category.class, id);
        	category.setName(name);
        	em.merge(category);
        	t.commit();
        }catch(Exception e){
            t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

}

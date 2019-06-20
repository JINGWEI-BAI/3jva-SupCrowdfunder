package com.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supcrowdfunder.dao.ProductDao;
import com.supcrowdfunder.entity.Category;
import com.supcrowdfunder.entity.Product;
import com.supcrowdfunder.entity.User;

public class JpaProductDao implements ProductDao{

	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaProductDao(EntityManagerFactory entityManagerFactory){
        this.myEntityManagerFactory = entityManagerFactory;
	}
	
	
	@Override
	public Product addProduct(Product product) {
        EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(product);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		return product;
	}

	@Override
	public Product retrieveProductById(Long id) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Product product;
		product = em.find(Product.class, id);
		em.close();
		return product;
	}

	@Override
	public List<Product> retrieveAllProducts() {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT p from Product as p");
        List<Product> products = query.getResultList();
		return products;
	}

	@Override
	public void removeProduct(Long id) {
		 EntityManager em = myEntityManagerFactory.createEntityManager();
	     EntityTransaction t = em.getTransaction();
	     try{
	      	t.begin();
	       	Product product = em.find(Product.class,id );
	        em.remove(product) ;
	        t.commit();
	     }catch(Exception e){
	      	t.rollback();
	     }finally{
	        em.close();
	     }		
	}


	@Override
	public List<Product> retrieveProductsUnder(float completion) {
        EntityManager em = myEntityManagerFactory.createEntityManager();
        List<Product> products;
        try{
            Query query = em.createQuery("SELECT p FROM Product as p where p.completion < :completion");
            query.setParameter("completion", completion);
            products =  query.getResultList();
	    }catch( Exception e){
	    	products = null;
    	}finally{
    		em.close();
    	}
        return products;
	}
	@Override
	public void updateProduct(Long id,String name,String content,Float completion, Category category){
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	Product product = em.find(Product.class, id);
        	product.setName(name);
        	product.setContent(content);
        	product.setCompletion(completion);
        	product.setCategory(category);
        	em.merge(product);
        	
        	t.commit();
        }catch(Exception e){
            t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
	}


	@Override
	public void contribute(Long id, Float num, Float oldnum) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	Product product = em.find(Product.class, id);
        	product.setCompletion(num + oldnum);
        	em.merge(product);
        	
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

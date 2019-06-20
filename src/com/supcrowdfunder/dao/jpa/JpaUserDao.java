package com.supcrowdfunder.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import com.supcrowdfunder.dao.UserDao;
import com.supcrowdfunder.entity.User;


public class JpaUserDao implements UserDao {

private EntityManagerFactory myEntityManagerFactory;
	
	public JpaUserDao(EntityManagerFactory entityManagerFactory){
        this.myEntityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public User addUser(User user) {
        EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(user);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		return user;
	}
	@Override
	public void updateUser(Long id,String email,String fname,String lname,String pwd){
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	User user = em.find(User.class, id);
        	user.setEmail(email);
        	user.setFirstname(fname);
        	user.setLastname(lname);
        	user.setPassword(pwd);
        	em.merge(user);
        	
        	t.commit();
        }catch(Exception e){
            t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
	}

	@Override
	public User retrieveUserById(Long id) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		User user;
	    user = em.find(User.class, id);
		em.close();
		return user;
	}

	@Override
	public List<User> retrieveAllUsers() {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT u from User as u");
        List<User> users = query.getResultList();
		return users;
	}

	@Override
	public void removeUser(Long id) {
		 EntityManager em = myEntityManagerFactory.createEntityManager();
	     EntityTransaction t = em.getTransaction();
	     try{
	      	t.begin();
	       	User user = em.find(User.class,id );
	        em.remove(user) ;
	        t.commit();
	     }catch(Exception e){
	      	t.rollback();
	     }finally{
	        em.close();
	     }		
	}


	
}

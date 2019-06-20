package com.supcrowdfunder.dao;

import com.supcrowdfunder.dao.jpa.JpaCategoryDao;
import com.supcrowdfunder.dao.jpa.JpaProductDao;
import com.supcrowdfunder.dao.jpa.JpaUserDao;
import com.supcrowdfunder.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory(){
	}
	
	
	public static ProductDao retrieveProductDao() {
		JpaProductDao productDao = new JpaProductDao(PersistenceManager.retrieveEntityManagerFactory());
	    return productDao;
   }

	public static CategoryDao retrieveCategoryDao() {
		JpaCategoryDao categoryDao = new JpaCategoryDao(PersistenceManager.retrieveEntityManagerFactory());
	    return categoryDao;
   }
	
	public static UserDao retrieveUserDao() {
		JpaUserDao UserDao = new JpaUserDao(PersistenceManager.retrieveEntityManagerFactory());
	    return UserDao;
   }
	
}

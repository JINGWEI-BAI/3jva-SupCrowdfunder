package com.supcrowdfunder.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.supcrowdfunder.util.PersistenceManager;

@WebListener
public class PersistenceAppListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
        PersistenceManager.closeEntityManagerFactory();		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
	
	}

}

package edu.mum.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.mum.domain.User;
import edu.mum.service.UserService;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"context/applicationContext.xml");

		User u = new User();
		u.setFirstName("John");
		u.setLastName("Doe");
		u.setEmail("John.Doe@mum.edu");
		u.setAdmin(false);

		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");

		userService.save(u);
		User uf = userService.findByEmail("John.Doe@mum.edu");
		System.out.println("************* User *************");
		System.out.println("User Name:  " + uf.getFirstName() + " " + uf.getLastName());
		
		// Exercise the Merge capability: 
		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) applicationContext.getBean("entityManagerFactory");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		//		Create an entity, 
		User u2 = new User();
		u2.setFirstName("newFirst");
		u2.setLastName("newLast");
		u2.setEmail("newEmail");
		u2.setAdmin(false);
		em.persist(u2);
//		Update entity; 
		u2.setEmail("newEmail2");
		u2.setAdmin(true);
		u2 = em.merge(u2);
//		try updating the entity again with the “unmanaged” version of the entity. 
//		Expected result: StaleObjectStateException.
		
		// use debug mode to stop here and change the version of the first data 
		// by using mysql workbench, then cause the StaleObjectStateException
		// Caused by: org.hibernate.StaleObjectStateException: 
		// Row was updated or deleted by another transaction 
		// (or unsaved-value mapping was incorrect) : [edu.mum.domain.User#1]
		u = em.merge(u);

		// Exercise the Flush/Refresh capability.
		u.setFirstName("test flush");
		em.flush();  // when flush, do update here, or do update on commit
		em.refresh(u);  // select the newest data again
		u = em.merge(u);
		
		em.getTransaction().commit();
		em.close();
	}

}
package edu.mum.main;

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
		u.setEmail("newEmail");
		u.setAdmin(false);

		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");

		userService.save(u);
		User uf = userService.findByEmail("newEmail");
		System.out.println("************* User *************");
		System.out.println("User Name:  " + uf.getFirstName() + " " + uf.getLastName());
		
		// Exercise the Merge capability: 
		// TODO
//		EntityManagerFactory entityManagerFactory = (EntityManagerFactory) applicationContext.getBean("entityManagerFactory");
//		entityManagerFactory.
		//		Create an entity, 
//		Update entity; 
//		try updating the entity again with the “unmanaged” version of the entity. 
//		Expected result: StaleObjectStateException.

		// Exercise the Flush/Refresh capability.

	}

}
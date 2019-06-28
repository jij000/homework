package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.mum.cs544.Student;
import edu.mum.cs544.Employee;

/**
 * Hello world!
 *
 */
public class App {
	private static EntityManagerFactory emf;

	public static void main(String[] args) throws Exception {
		emf = Persistence.createEntityManagerFactory("cs544");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// TODO
		em.getTransaction().commit();
		em.close();
	}
}

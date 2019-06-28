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
		//a) Create a Bidirectional OneToMany/ManyToOne association between Employee
		//and Laptop using a Set.
		Employee employee1 = new Employee();
		employee1.setName("eee111");
		em.persist(employee1);
		Laptop laptop1 = new Laptop();
		laptop1.setModel("DELL");
		laptop1.setEmployee(employee1);
		Laptop laptop2 = new Laptop();
		laptop2.setModel("HP");
		laptop2.setEmployee(employee1);
		em.persist(laptop1);
		em.persist(laptop2);

		//b) Create a Unidirectional OneToMany between Passenger and Flight using a List.
		//Please note that ‘TO’ and ‘FROM’ are SQL keywords and should either be escaped with
		//backticks like `to` or changed to a different column name using the @Column annotation
		Passenger passenger1 = new Passenger();
		passenger1.setName("ppp111");
		Passenger passenger2 = new Passenger();
		passenger2.setName("ppp222");
		em.persist(passenger1);
		em.persist(passenger2);

		Flight flight1 = new Flight();
		flight1.setFlightName("flight1");
		flight1.getPassengers().add(passenger1);
		flight1.getPassengers().add(passenger2);
		em.persist(flight1);

		//c) Create a Unidirectional OneToMany association between School and Student
		//using a Map, where studentId is used as the key for the map (in this scenario studentid
		//needs to be an assigned value, not generated).
		Student student1 = new Student();
		student1.setStudentId(1);
		student1.setStudentName("sss111");
		Student student2 = new Student();
		student1.setStudentId(2);
		student2.setStudentName("sss222");
		em.persist(student1);
		em.persist(student2);
		School school1 = new School();
		school1.setSchoolName("school1");
		school1.getStudentMap().put(String.valueOf(student1.getStudentId()), student1);
		school1.getStudentMap().put(String.valueOf(student2.getStudentId()), student2);
		em.persist(school1);

		em.getTransaction().commit();
		em.close();
	}
}

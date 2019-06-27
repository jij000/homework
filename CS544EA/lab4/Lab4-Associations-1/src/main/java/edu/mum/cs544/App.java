package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import edu.mum.cs544.Car;
import edu.mum.cs544.Owner;

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

        // Update the main method in App.javain so that it creates two cars, 
        // and associates an owner with each one before persisting it.  
        // Then when retrieving the cars also print the details of each owner.
		// Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        Owner o1 = new Owner("Owner1", "OwnerAddress1");
        car1.setOwner(o1);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        Owner o2 = new Owner("Owner2", "OwnerAddress2");
        car2.setOwner(o2);
        // save the car
        em.persist(car2);
        // retrieving the cars also print the details of each owner.
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice()
                    + ", Owner name= " + car.getOwner().getName()
                    + ", Owner address= " + car.getOwner().getAddress());
        }
		em.getTransaction().commit();
		em.close();
	}
}

package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // a) Create a small hibernate application that uses the following entities:
        // Test the application by creating an object tree of the given domain classes, saving this
        //tree to the database, and then retrieving the objects from the database to check if
        //everything was persisted correctly.

        Order order1 = new Order();
        order1.setDate(LocalDate.now());
        Order order2 = new Order();
        order2.setDate(LocalDate.now());
        em.persist(order1);
        em.persist(order2);

        Customer customer = new Customer();
        customer.setFirstName("CustomerFirst");
        customer.setLastName("CustomerLast");
        customer.getOrderList().add(order1);
        customer.getOrderList().add(order2);
        em.persist(customer);
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        OrderLine orderLine1 = new OrderLine();
        OrderLine orderLine2 = new OrderLine();
        OrderLine orderLine3 = new OrderLine();
        OrderLine orderLine4 = new OrderLine();
        orderLine1.setQuantity(1);
        orderLine2.setQuantity(2);
        orderLine3.setQuantity(3);
        orderLine4.setQuantity(4);
        em.persist(orderLine1);
        em.persist(orderLine2);
        em.persist(orderLine3);
        em.persist(orderLine4);

        order1.getOrderLineList().add(orderLine1);
        order1.getOrderLineList().add(orderLine2);
        order2.getOrderLineList().add(orderLine3);
        order2.getOrderLineList().add(orderLine4);

        Product product1 = new Product();
        Product product2 = new Product();
        product1.setName("Book");
        product1.setDescription("good book");
        product2.setName("PEN");
        product2.setDescription("good pen");
        em.persist(product1);
        em.persist(product2);

        orderLine1.setProduct(product1);
        orderLine2.setProduct(product2);
        orderLine3.setProduct(product2);
        orderLine4.setProduct(product1);


        // b) Change the application to use the following updated domain:
        CD cd1 = new CD();
        cd1.setName("CD");
        cd1.setDescription("good CD");
        cd1.setArtist("art111");
        em.persist(cd1);

        DVD dvd1 = new DVD();
        dvd1.setName("DVD");
        dvd1.setDescription("good DVD");
        dvd1.setGenre("genre111");
        em.persist(dvd1);

        Book book1 = new Book();
        book1.setName("Book");
        book1.setDescription("good Book");
        book1.setTitle("title111");
        em.persist(book1);

        orderLine4.setProduct(dvd1);

//        System.out.println(customer);
        em.getTransaction().commit();
        em.close();
    }
}

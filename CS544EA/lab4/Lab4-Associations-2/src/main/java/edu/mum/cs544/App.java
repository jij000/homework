package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //a) Create a Bidirectional OneToMany association between Department and
        //Employee using annotations.
        Department d1 = new Department();
        d1.setDepartmentName("ddd1");
        Employee e1 = new Employee();
        e1.setName("eee1");
        Employee e2 = new Employee();
        e2.setName("eee2");
        d1.getEmployeeList().add(e1);
        d1.getEmployeeList().add(e2);
        em.persist(d1);
        e1.setDepartment(d1);
        em.persist(e1);
        e2.setDepartment(d1);
        em.persist(e2);
        //b) Create an Optional Unidirectional ManyToOne association between Book and
        //Publisher using annotations and without using NULL fields in the database
        Book b1 = new Book();
        b1.setBookName("book1");
        Book b2 = new Book();
        b2.setBookName("book2");
        Publisher p1 = new Publisher();
        p1.setPublisherName("PublisherName1");
        em.persist(p1);

        b1.setPublisher(p1);
        b2.setPublisher(p1);
        em.persist(b1);
        em.persist(b2);

        //c) Create a Bidirectional ManyToMany association between Student and Course
        //using annotations. Be sure to make studentid values application assigned (not generated)!
        Course c1 = new Course();
        c1.setCourseName("ccc1");
        Course c2 = new Course();
        c2.setCourseName("ccc2");

        Student s1 = new Student();
//        s1.setStudentId(1);
        s1.setStudentName("sss1");
        Student s2 = new Student();
//        s2.setStudentId(2);
        s2.setStudentName("sss2");

        c1.getStudentList().add(s1);
        c1.getStudentList().add(s2);

        em.persist(c1);
        em.persist(c2);
        // ManyToMany
        s1.getCourseList().add(c1);
        s1.getCourseList().add(c2);
        s2.getCourseList().add(c1);
        s2.getCourseList().add(c2);
        em.persist(s1);
        em.persist(s2);



        //d) Create a Unidirectional OneToMany association between Customer and
        //Reservation using annotations.
        Customer customer1 = new Customer();
        customer1.setCustomerName("ccc111");
        Reservation reservation1 = new Reservation();
        reservation1.setReservationName("rrr111");
        Reservation reservation2 = new Reservation();
        reservation2.setReservationName("rrr222");
        em.persist(reservation1);
        em.persist(reservation2);

        customer1.getReservationList().add(reservation1);
        customer1.getReservationList().add(reservation2);
        em.persist(customer1);
        //e) Create a Unidirectional ManyToOne association between Reservation and
        //Book using annotations.
        Book b3 = new Book();
        b3.setBookName("book3");
        b3.setPublisher(p1);
        em.persist(b3);
        reservation1.setBook(b3);
        em.merge(reservation1);

        //f) Create a Bidirectional ManyToOne association between Employee and Office
        //using annotations.
        Office o1 = new Office();
        o1.setOfficeName("ooo111");
        o1.getEmployeeList().add(e2);
        o1.getEmployeeList().add(e1);
        em.persist(o1);

        em.getTransaction().commit();
        em.close();
    }
}

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
        // Create an application that maps the following classes onto the tables listed next to them:

        Patient patient1 = new Patient();
        patient1.setName("John Doe");
        patient1.setStreet("100 Main Street");
        patient1.setCity("Boston");
        patient1.setZip("23114");
        em.persist(patient1);

        Doctor doctor1 = new Doctor();
        doctor1.setDoctorType("Eye Doctor");
        doctor1.setFirstName("Frank");
        doctor1.setLastName("Brown");
        em.persist(doctor1);

        Appointment appointment1 = new Appointment();
        appointment1.setAppdate("15/05/08");
        appointment1.setDoctor(doctor1);
        appointment1.setPatient(patient1);
        Payment payment = new Payment();
        payment.setPayDate("12/06/08");
        payment.setAmount(100);
        appointment1.setPayment(payment);
        em.persist(appointment1);

        System.out.println(patient1);
        System.out.println(doctor1);
        System.out.println(appointment1);

        em.getTransaction().commit();
        em.close();
    }
}

package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("simpsons");
        // Open a EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // Retrieve all students from the database and display their names
        // important: your query needs to be: from edu.mum.cs544.Students
        TypedQuery<Students> query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        List<Students> studentsList = query.getResultList();
        for (Students student : studentsList) {
            System.out.println("name= " + student.getName());
        }
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();

        // open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // Add an extra student to the database (you can choose his / her name)
        Students newStudent = new Students();
        newStudent.setId(999);
        newStudent.setName("new student");
        newStudent.setPassword("new password");
        newStudent.setEmail("new email");
        em.persist(newStudent);
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();

        // Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // Retrieve all books and output them to the console
        query = em.createQuery("from edu.mum.cs544.Students", Students.class);
        studentsList = query.getResultList();
        for (Students student : studentsList) {
            System.out.println("name= " + student.getName());
        }
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();
    }
}

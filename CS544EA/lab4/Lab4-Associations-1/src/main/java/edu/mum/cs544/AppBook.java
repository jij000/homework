package edu.mum.cs544;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;

public class AppBook {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        // Open a EntityManager
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // Create 3 books save them to the database
        Book book1 = new Book("book111", "1111", "author1", 100.1, LocalDate.now());
        em.persist(book1);
        Book book2 = new Book("book222", "2222", "author2", 100.2, LocalDate.now());
        em.persist(book2);
        Book book3 = new Book("book333", "3333", "author3", 100.3, LocalDate.now());
        em.persist(book3);
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();

        // open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // Retrieve all books and output them to the console
        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("id= " + book.getId()
                    + ", title= " + book.getTitle() + ", ISBN= " + book.getISBN()
                    + ", author= " + book.getAuthor() + ", price= " + book.getPrice()
                    + ", publish_date= " + book.getPublish_date());
        }
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();

        // Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // Retrieve all books from the database, and then:
        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();
        //        o Change the title and price of one book
        bookList.get(1).setTitle("new Title");
        bookList.get(1).setPrice(200.2);
        //        o Use em.remove() to delete a different book (not the one that was just updated)
        em.remove(bookList.get(2));
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();

        // Open a EntityManager
        em = emf.createEntityManager();
        em.getTransaction().begin();
        // Retrieve all books and output them to the console
        query = em.createQuery("from Book", Book.class);
        bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("id= " + book.getId()
                    + ", title= " + book.getTitle() + ", ISBN= " + book.getISBN()
                    + ", author= " + book.getAuthor() + ", price= " + book.getPrice()
                    + ", publish_date= " + book.getPublish_date());
        }
        // Close the EntityManager
        em.getTransaction().commit();
        em.close();
    }
}

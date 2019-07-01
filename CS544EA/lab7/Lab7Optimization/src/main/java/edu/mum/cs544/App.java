package edu.mum.cs544;

import java.util.List;

import javax.persistence.*;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        // start time
        long start = System.nanoTime();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

//        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);

        // d) Remove the sub-select strategy and use a join fetch query in
        //App.java to retrieve everything. Also check the difference between us-
        //ing a named query, or just a query directly in code.
//        TypedQuery<Owner> query = em.createQuery("from Owner o join fetch o.pets ", Owner.class);
        // [OUTPUT]>>> : To fetch this data from the database took 20074 milliseconds.
        // e) Lastly modify the application to use an Entity Graph instead of a join fetch.
        EntityGraph<Owner> graph = em.createEntityGraph(Owner.class);
        graph.addSubgraph("pets");
        TypedQuery<Owner> query = em.createQuery("from Owner", Owner.class);
        query.setHint("javax.persistence.fetchgraph", graph);
        // [OUTPUT]>>> : To fetch this data from the database took 38059 milliseconds.
        List<Owner> ownerlist = query.getResultList();
        for (Owner o : ownerlist) {
            o.getPets().size();
        }

        em.getTransaction().commit();
        em.close();
        long stop = System.nanoTime();

        // stop time
        System.out.println("To fetch this data from the database took " + (stop - start) / 1000000 + " milliseconds.");
        System.exit(0);
    }

}

package edu.mum.dao.impl;


import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public User findByEmail(String email) {
        Query query = entityManager.createQuery("select u from users u  where u.email =:email");
        return (User) query.setParameter("email", email).getSingleResult();

    }

}
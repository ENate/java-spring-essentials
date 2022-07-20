package com.minejava.tcexample.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import org.springframework.stereotype.Repository;

import com.minejava.tcexample.model.User;


@Repository
public class UserClassicJpaRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    public Collection<User> allUsers() {
        return em.createQuery("Select user FROM user user", User.class).getResultList();
    }

    public Collection<User> findUsersBySearchCriteria(String searchCriteria) {
        return em.createQuery("SELECT user FROM user user " +
                        "where user.userName LIKE :searchCriteria OR " +
                        "user.firstName LIKE :searchCriteria OR " +
                        "user.lastName = :searchCriteria",
                User.class)
                .setParameter("searchCriteria", searchCriteria).getResultList();
    }
}

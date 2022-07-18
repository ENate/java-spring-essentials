package com.minejava.tcexample.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.minejava.tcexample.model.User;

@Repository
public class UserRepositoryImpl {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addUser(User user) {
        em.persist(user);
    }

    public Collection<User> allUsers() {
        return em.createQuery("Select user FROM User user", User.class).getResultList();
    }

    public Collection<User> findUsersBySearchCriteria(String searchCriteria) {
        return em.createQuery("SELECT user FROM User user " +
                        "where user.userName LIKE :searchCriteria OR " +
                        "user.firstName LIKE :searchCriteria OR " +
                        "user.lastName = :searchCriteria",
                User.class)
                .setParameter("searchCriteria", searchCriteria).getResultList();
    }
}

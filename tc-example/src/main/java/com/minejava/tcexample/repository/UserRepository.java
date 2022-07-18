package com.minejava.tcexample.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.minejava.tcexample.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // List<User> findByUserName(String userName);
    Collection<User> findAllUsers();
    Collection<User> addUser();

    @Query("SELECT user FROM User user where user.username LIKE :searchCriteria OR user.firstname LIKE :searchCriteria OR user.lastname = :searchCriteria")
    Collection<User> findUsersBySearchCriteria(String searchCriteria);
}

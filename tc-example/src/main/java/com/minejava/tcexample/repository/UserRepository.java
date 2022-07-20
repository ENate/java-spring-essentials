package com.minejava.tcexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minejava.tcexample.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    // List<User> findByUserName(String userName);
    //Collection<User> findAllUsers();
    //Collection<User> addUser();

    //@Query("SELECT user FROM User user where user.userName LIKE :searchCriteria OR user.firstName LIKE :searchCriteria OR user.lastName = :searchCriteria")
    //Collection<User> findUsersBySearchCriteria(String searchCriteria);
}

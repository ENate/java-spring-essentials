package com.minejava.tcexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minejava.tcexample.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByUserName(String userName);
}

package com.minejava.testcontainers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.minejava.testcontainers.model.Customer;

@Service
public class CustomerDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> findAll() {
        return jdbcTemplate.query(
                "SELECT id, first_name, last_name FROM customers",
                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        );
    }
}

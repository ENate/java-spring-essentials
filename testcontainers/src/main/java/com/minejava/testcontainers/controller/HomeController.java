package com.minejava.testcontainers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.minejava.testcontainers.model.Customer;
import com.minejava.testcontainers.service.CustomerDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/")
    public List<Customer> customers() {
        List<Customer> customers = customerDao.findAll();
        customers.forEach(c -> log.info("Found a customer: {}", c));
        return customers;
    }
}

package com.minejava.testcontainers;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.minejava.testcontainers.model.Customer;
import com.minejava.testcontainers.service.CustomerDao;
import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class TestContainerApplicationTests {

    @Autowired
    private CustomerDao customerDao;

    // Prevents different databases when test container is run
    // static means run tests for entire class: started container before all tests
    // and shuts down after all runs
    @Container
    private static MySQLContainer<?> container = new MySQLContainer<>("mysql:8.0.26")
                .withInitScript("../schema.sql");



    @Test
    void should_clened_db_when_empty() {
        List<Customer> customers = customerDao.findAll();
        assertThat(customers).hasSize(2);

    }

}

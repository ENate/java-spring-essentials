package com.minejava.tcexample;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.minejava.tcexample.model.User;
import com.minejava.tcexample.repository.UserRepositoryImpl;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Testcontainers
public class TcExampleApplicationTests {

    @Container
    private static MySQLContainer<?> dContainer = new MySQLContainer<>("mysql:latest");

    @Autowired
    UserRepositoryImpl userRepositoryImpl;

    @Test
    void findUserByCriteria() {
        User newUser = myUser();
        userRepositoryImpl.addUser(newUser);
        // Call serach criteria method

        Collection<User> users = userRepositoryImpl.findUsersBySearchCriteria("Mando");
        assertThat(users).contains(newUser);
    }

    private User myUser() {
        User oneUser = User.builder()
                .userName("Mando")
                .firstName("Gambo")
                .lastName("Saidouye")
                .build();
        return oneUser;
    }

    @DynamicPropertySource
    static void databaseProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.database.url", dContainer::getJdbcUrl);
        registry.add("spring.datasource.username", dContainer::getUsername);
        registry.add("spring.datasource", dContainer::getPassword);
    }
}

package com.minejava.tcexample.repository;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.minejava.tcexample.model.User;
import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class UserClassicJpaRepositoryIT {

    @Container
    public static MySQLContainer<?> dCon = new MySQLContainer<>("mysql:latest")
    .withInitScript("init_mysql.sql");
    //.withDatabaseName("test")
    //.withExposedPorts(3306);

    @Autowired
    private UserClassicJpaRepository userRepo;

    @Test
    void findUserByCriteria(){
        userRepo.addUser(
            User.builder()
            .id(3)
                .userName("Dangoba")
                .firstName("Sanderger")
                .lastName("Safger")
                .build());

        Collection<User> users = userRepo.findUsersBySearchCriteria("Dangoba");

        assertThat(users).contains(
            User.builder()
                .id(3)
                .userName("Dangoba")
                .firstName("Sanderger")
                .lastName("Safger")
                .build()
        );
    }


    // @DynamicPropertySource
    // static void databaseProperties(DynamicPropertyRegistry registry) {
    //     registry.add("spring.database.url", dCon::getJdbcUrl);
    //     registry.add("spring.datasource.username", dCon::getUsername);
    //     registry.add("spring.datasource.password", dCon::getPassword);
    //     registry.add("spring.datasource.driver-class-name", dCon::getDriverClassName);
    // }
}

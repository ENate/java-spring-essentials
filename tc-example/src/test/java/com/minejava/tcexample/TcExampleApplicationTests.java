package com.minejava.tcexample;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.minejava.tcexample.model.User;
import com.minejava.tcexample.repository.UserClassicJpaRepository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

@Testcontainers
@SpringJUnitWebConfig
@AutoConfigureMockMvc
@SpringBootTest(classes = TcExampleApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = { TcExampleApplicationTests.Initializer.class })
//@ContextConfiguration(initializers = {TcExampleApplicationTests.Initializer.class})
public class TcExampleApplicationTests {

    @Autowired
    private UserClassicJpaRepository userRepo;

    @ClassRule
public static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:latest")
        .withInitScript("init_mysql.sql")
        .withDatabaseName("sampleapp")
        .withUsername("user")
        .withPassword("password");

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
                .userName("Dangoba")
                .firstName("Sanderger")
                .lastName("Safger")
                .build()
        );
    }
    static class Initializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        TestPropertyValues.of(
                "spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + mySQLContainer.getUsername(),
                "spring.datasource.driver-class-name=" + mySQLContainer.getDriverClassName(),
                "spring.jpa.database-platform=org.hibernate.dialect.MySQL8InnoDBDialect",
                "spring.datasource.password=" + mySQLContainer.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}
}

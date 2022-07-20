package com.minejava.tcexample.repository;
import org.testcontainers.ext.ScriptUtils;

import java.util.Collection;
import javax.sql.DataSource;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.minejava.tcexample.model.User;
import com.mysql.cj.jdbc.MysqlDataSource;

import static org.assertj.core.api.Assertions.assertThat;


@Testcontainers
public class UserClassicJDBCRepositoryIT {

    @Container
    private MySQLContainer<?> database = new MySQLContainer<>("mysql:latest");

    private UserClassicJDBCRepository repositoryUnderTest;

    @Test
    void testInteractionWithDatabase() {
        ScriptUtils.runInitScript(new JdbcDatabaseDelegate(database, ""),"init_mysql.sql");
        repositoryUnderTest = new UserClassicJDBCRepository(dataSource());

        repositoryUnderTest.addUser(User.builder()
                .userName("Marker")
                .firstName("Donder")
                .lastName("Extracs")
                .build()
        );

        Collection<User> users = repositoryUnderTest.allUsers();

        assertThat(users).hasSize(3);
    }

    @NotNull
    private DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(database.getJdbcUrl());
        dataSource.setUser(database.getUsername());
        dataSource.setPassword(database.getPassword());
        return dataSource;
    }

}

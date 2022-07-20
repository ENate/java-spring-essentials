package com.minejava.tcexample.repository;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.minejava.tcexample.model.User;

@Repository
public class UserClassicJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserClassicJDBCRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addUser(User user) {
        jdbcTemplate.update("insert into user (userName, firstName, lastName) values (?,?,?)",
                user.getUserName(), user.getFirstName(), user.getLastName());

    }

    public Collection<User> allUsers() {
        return jdbcTemplate.query("select * From user",
                (resultSet, i) -> new User(i, resultSet.getString("userName"),
                                            resultSet.getString("firstName"),
                                            resultSet.getString("lastName")));
    }
}

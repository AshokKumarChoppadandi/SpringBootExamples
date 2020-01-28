package com.java.spring.jdbc_to_jpa;

import com.java.spring.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// Custom Row Mapper
public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setLocation(resultSet.getString("location"));
        person.setBirthDate(resultSet.getTimestamp("birth_date"));
        return person;
    }
}

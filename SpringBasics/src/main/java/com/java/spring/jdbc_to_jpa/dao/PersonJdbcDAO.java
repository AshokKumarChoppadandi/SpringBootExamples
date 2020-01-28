package com.java.spring.jdbc_to_jpa.dao;

import com.java.spring.entity.Person;
import com.java.spring.jdbc_to_jpa.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // BeanPropertyRowMapper is the built in Row Mapper
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Person findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from person where id = ?", new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public List<Person> findAllByLocation(String location) {
        return jdbcTemplate.query("select * from person where location = ?", new Object[] { location }, new BeanPropertyRowMapper<Person>(Person.class));
    }

    public Integer deleteById(Integer id) {
        return jdbcTemplate.update("delete person where id = ?", id);
    }

    public Integer insertPerson(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?, ?, ?, ?)",  person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    public Integer updatePerson(Person person2) {
        return jdbcTemplate.update(
                "update person set name = ?, location = ?, birth_date = ? where id = ?",
                person2.getName(),
                person2.getLocation(),
                person2.getBirthDate(),
                person2.getId()
        );
    }

    public List<Person> findAll2() {
        return jdbcTemplate.query(
                "select * from person",
                new PersonRowMapper()
        );
    }

    // Custom RowMapper using LAMBDA / Anonymous function
    public List<Person> findAll3() {
        return jdbcTemplate.query(
                "select * from person",
                ((resultSet, i) -> new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("location"),
                        resultSet.getTimestamp("birth_date")
                ))
        );
    }
}

package com.java.springboot.sms.repo;

import com.java.springboot.sms.entity.CricketerEntity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class JpaCricketerDAOTest {

    @Autowired
    private JpaCricketerDAO dao;

    /*@Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Integer> mapper = (resultSet, i) -> resultSet.getInt("id");*/

    @Test
    public void saveTest() {
        CricketerEntity cricketer = new CricketerEntity("All Rounder", "Hardhik", "Pandya");
        cricketer = dao.save(cricketer);

        Assertions.assertNotNull(cricketer.getId());
    }

    @Test
    public void findByIdTest() {
        Optional<CricketerEntity> cricketer = dao.findById(1);
        CricketerEntity entity = new CricketerEntity(1, "Batsman", "Rohit", "Sharma");

        Assertions.assertTrue(cricketer.isPresent());
        Assertions.assertEquals(entity, cricketer.get());
    }

    @Test
    public void findByIdNegativeTest() {
        Optional<CricketerEntity> cricketer = dao.findById(999);
        Assertions.assertFalse(cricketer.isPresent());
    }

    @Test
    public void findAllTest() {
        List<CricketerEntity> entityList = dao.findAll();
        List<String> names = entityList.stream().map(CricketerEntity::getFirstName).collect(Collectors.toList());

        MatcherAssert.assertThat(names, Matchers.containsInAnyOrder("Rohit", "Bhuvaneshwar", "Mahendra Singh", "Virat", "Shami"));
    }

    @Test
    public void countTest() {
        Long count = dao.count();
        Assertions.assertEquals(5, count);
    }

    @Test
    public void deleteTest() {
        CricketerEntity entity = new CricketerEntity(1, "Batsman", "Rohit", "Sharma");
        System.out.println("TEST LINE");
        dao.delete(entity);

        Optional<CricketerEntity> entityOptional = dao.findById(1);
        Assertions.assertFalse(entityOptional.isPresent());
    }

    @Test
    public void deleteByIdTest() {
        Optional<CricketerEntity> entityOptional = dao.findById(1);
        Assertions.assertTrue(entityOptional.isPresent());
        dao.deleteById(1);

        Optional<CricketerEntity> entityOptional2 = dao.findById(1);
        Assertions.assertFalse(entityOptional2.isPresent());
    }

    @Test
    public void existsByIdTest() {
        Boolean bool = dao.existsById(2);
        Assertions.assertTrue(bool);
    }
}

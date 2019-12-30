package com.java.springboot.sms.repo;

import com.java.springboot.sms.entity.Cricketer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Adding @Transactional Annotation helps in not storing the test data into the Database.
// The data used for the tests will never save in the Database.
@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JdbcCricketerDAOTest {

    @Autowired
    private JdbcCricketerDAO dao;

    @Test
    public void saveTest() {
        Cricketer cricketer = new Cricketer("All Rounder", "Hardhik", "Pandya");
        Cricketer cricketer1 = dao.save(cricketer);

        Assertions.assertNotNull(cricketer1.getId());
    }

    @Test
    public void findByIdTest() {
        Optional<Cricketer> cricketer = dao.findById(1);
        Cricketer expected = new Cricketer(1, "Batsman", "Rohit", "Sharma");
        Assertions.assertTrue(cricketer.isPresent());
        Assertions.assertEquals(expected, cricketer.get());
    }

    @Test
    public void findByIdNegativeTest() {
        Optional<Cricketer> cricketer = dao.findById(999);
        Assertions.assertFalse(cricketer.isPresent());
    }

    @Test
    public void findAllTest() {
        List<Cricketer> cricketers = dao.findAll();
        List<String> cricketerNames = cricketers.stream().map(Cricketer::getFirstName).collect(Collectors.toList());

        MatcherAssert.assertThat(
                cricketerNames,
                Matchers.containsInAnyOrder(
                        "Rohit", "Bhuvaneshwar", "Mahendra Singh", "Virat", "Shami"
                )
        );
    }

    @Test
    public void countTest() {
        long count = dao.count();
        Assertions.assertEquals(5, count);
    }

    @Test
    public void deleteTest() {
        /*
        If @Transactional is not added then this code is required to test the original code.
        Integer newId = insertTestRecord();
        Optional<Cricketer> cricketer = dao.findById(1);

        Assertions.assertTrue(cricketer.isPresent());
        */

        Cricketer cricketer = new Cricketer(1, "Batsman", "Rohit", "Sharma");

        dao.delete(cricketer);
        Optional<Cricketer> cricketer1 = dao.findById(1);
        Assertions.assertFalse(cricketer1.isPresent());
    }

    @Test
    public void deleteByIdTest() {
        /*If @Transactional is not added then this code is required to test the original code.
        Integer newId = insertTestRecord();
        Optional<Cricketer> cricketer = dao.findById(newId);

        Assertions.assertTrue(cricketer.isPresent());*/

        dao.deleteById(1);
        Optional<Cricketer> cricketer1 = dao.findById(1);
        Assertions.assertFalse(cricketer1.isPresent());
    }

    @Test
    public void existsByIdTest() {
        /*If @Transactional is not added then this code is required to test the original code.
        Integer newId = insertTestRecord();
        Boolean expected = dao.existsById(newId);

        Assertions.assertTrue(expected);

        dao.deleteById(newId);*/
        Boolean expected2 = dao.existsById(1);

        Assertions.assertTrue(expected2);
    }

    /*If @Transactional is not added then this code is required to test the original code.
    private Integer insertTestRecord() {
        Cricketer cricketer = new Cricketer("Wicket Keeper", "Dinesh", "Karthik");
        Cricketer cricketer1 = dao.save(cricketer);
        return cricketer1.getId();
    }*/
}

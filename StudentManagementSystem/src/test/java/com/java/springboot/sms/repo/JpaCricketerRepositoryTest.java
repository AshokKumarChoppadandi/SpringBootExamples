package com.java.springboot.sms.repo;

import com.java.springboot.sms.entity.CricketerEntity;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class JpaCricketerRepositoryTest {

    @Autowired
    private JpaCricketerRepository repository;

    @Test
    public void saveTest() {
        CricketerEntity cricketer = new CricketerEntity("All Rounder", "Hardhik", "Pandya");
        cricketer = repository.save(cricketer);

        Assertions.assertNotNull(cricketer.getId());
    }

    @Test
    public void findByIdTest() {
        Optional<CricketerEntity> cricketer = repository.findById(1);
        CricketerEntity entity = new CricketerEntity(1, "Batsman", "Rohit", "Sharma");

        Assertions.assertTrue(cricketer.isPresent());
        Assertions.assertEquals(entity, cricketer.get());
    }

    @Test
    public void findByIdNegativeTest() {
        Optional<CricketerEntity> cricketer = repository.findById(999);
        Assertions.assertFalse(cricketer.isPresent());
    }

    @Test
    public void findAllTest() {
        List<CricketerEntity> entityList = repository.findAll();
        List<String> names = entityList.stream().map(CricketerEntity::getFirstName).collect(Collectors.toList());

        MatcherAssert.assertThat(names, Matchers.containsInAnyOrder("Rohit", "Bhuvaneshwar", "Mahendra Singh", "Virat", "Shami"));
    }

    @Test
    public void countTest() {
        Long count = repository.count();
        Assertions.assertEquals(5, count);
    }

    @Test
    public void deleteTest() {
        CricketerEntity entity = new CricketerEntity(1, "Batsman", "Rohit", "Sharma");
        System.out.println("TEST LINE");
        repository.delete(entity);

        Optional<CricketerEntity> entityOptional = repository.findById(1);
        Assertions.assertFalse(entityOptional.isPresent());
    }

    @Test
    public void deleteByIdTest() {
        Optional<CricketerEntity> entityOptional = repository.findById(1);
        Assertions.assertTrue(entityOptional.isPresent());
        repository.deleteById(1);

        Optional<CricketerEntity> entityOptional2 = repository.findById(1);
        Assertions.assertFalse(entityOptional2.isPresent());
    }

    @Test
    public void existsByIdTest() {
        Boolean bool = repository.existsById(2);
        Assertions.assertTrue(bool);
    }

    @Test
    void findByLastNameTest() {
        List<CricketerEntity> cricketerEntities = repository.findAllByLastName("Sharma");
        Assertions.assertEquals(1, cricketerEntities.size());
        Assertions.assertEquals("Sharma", cricketerEntities.get(0).getLastName());
    }

    @Test
    void findByFirstNameAndLastNameTest() {
        List<CricketerEntity> cricketerEntities = repository.findAllByFirstNameAndLastName("Rohit", "Sharma");
        Assertions.assertEquals(1, cricketerEntities.size());
        Assertions.assertEquals(1, cricketerEntities.get(0).getId());
    }

    @Test
    public void findByFirstNameLikeOrLastNameLikeTest() {
        List<CricketerEntity> cricketerEntities = repository.findAllByFirstNameLikeOrLastNameLike("%t", "%i");
        List<Integer> ids = cricketerEntities.stream().map(CricketerEntity::getId).collect(Collectors.toList());
        Assertions.assertEquals(3, ids.size());
        MatcherAssert.assertThat(ids, Matchers.containsInAnyOrder(1, 3, 4));
    }
}

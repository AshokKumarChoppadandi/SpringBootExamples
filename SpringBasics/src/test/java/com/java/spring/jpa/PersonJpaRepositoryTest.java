package com.java.spring.jpa;

import com.java.spring.entity.PersonEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest
public class PersonJpaRepositoryTest {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Test
    public void saveTest() {
        PersonEntity personEntity = getPersonEntityRecord();
        PersonEntity personEntity1 = personJpaRepository.save(personEntity);

        Assertions.assertNotNull(personEntity1.getId());
    }

    @Test
    public void findAllTest() throws ParseException {
        String startDateString = "1988-01-01 00:00:00.000";
        String endDateString = "1991-01-01 00:00:00.000";

        List<PersonEntity> personEntities = personJpaRepository.getFilteredPersonDetails(
                dateFormat.parse(startDateString),
                dateFormat.parse(endDateString)
        );

        Assertions.assertEquals(2, personEntities.size());
    }

    private PersonEntity getPersonEntityRecord() {
        String dateString = "1990-09-04 10:20:30.456";
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new PersonEntity("Jamie Dimon", "USA", date);
    }
}

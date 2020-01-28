package com.java.spring.jpa;

import com.java.spring.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface PersonJpaRepository extends JpaRepository<PersonEntity, Integer> {

    @Query("select p from PersonEntity p where p.birthDate between :startDate and :endDate")
    public List<PersonEntity> getFilteredPersonDetails(Date startDate, Date endDate);

}

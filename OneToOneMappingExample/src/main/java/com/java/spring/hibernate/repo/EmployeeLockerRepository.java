package com.java.spring.hibernate.repo;

import com.java.spring.hibernate.entity.EmployeeLocker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeLockerRepository {

    @Autowired
    private EntityManager entityManager;

    public EmployeeLocker findById(Integer id) {
        return entityManager.find(EmployeeLocker.class, id);
    }
}

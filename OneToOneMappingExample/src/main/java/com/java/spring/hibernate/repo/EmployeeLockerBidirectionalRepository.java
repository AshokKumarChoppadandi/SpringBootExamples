package com.java.spring.hibernate.repo;

import com.java.spring.hibernate.entity.Department;
import com.java.spring.hibernate.entity.EmployeeLocker;
import com.java.spring.hibernate.entity.EmployeeLockerBidirectional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeLockerBidirectionalRepository {

    @Autowired
    private EntityManager entityManager;

    public EmployeeLockerBidirectional insertEmployee(EmployeeLockerBidirectional employee) {
        Department department = employee.getDepartment();
        EmployeeLocker locker = employee.getLocker();
        entityManager.persist(locker);
        entityManager.persist(department);
        entityManager.persist(employee);

        return entityManager.find(EmployeeLockerBidirectional.class, employee.getId());
    }

    public EmployeeLockerBidirectional findById(Integer id) {
        return entityManager.find(EmployeeLockerBidirectional.class, id);
    }

    public List<EmployeeLockerBidirectional> getAllEmployees() {
        TypedQuery<EmployeeLockerBidirectional> typedQuery = entityManager.createQuery("select e from EmployeeLockerBidirectional e", EmployeeLockerBidirectional.class);
        return typedQuery.getResultList();
    }
}

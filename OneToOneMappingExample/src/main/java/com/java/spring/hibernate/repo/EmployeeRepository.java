package com.java.spring.hibernate.repo;

import com.java.spring.hibernate.entity.Department;
import com.java.spring.hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    private EntityManager entityManager;

    public Employee insertEmployee(Employee employee) {
        Department department = employee.getDepartment();
        entityManager.persist(department);
        entityManager.persist(employee);
        return entityManager.find(Employee.class, employee.getId());
    }

    public List<Employee> getAllEmployees() {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("select e from Employee e", Employee.class);
        List<Employee> employees = typedQuery.getResultList();

        return employees;
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee findByName(String employeeName) {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("select e from Employee e where e.name like :employeeName", Employee.class);
        typedQuery.setParameter("employeeName", employeeName);

        return typedQuery.getSingleResult();
    }
}

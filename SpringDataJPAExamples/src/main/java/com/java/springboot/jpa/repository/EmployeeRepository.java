package com.java.springboot.jpa.repository;

import com.java.springboot.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //public List<Employee> findByDepartmentId(Integer departmentId);
}

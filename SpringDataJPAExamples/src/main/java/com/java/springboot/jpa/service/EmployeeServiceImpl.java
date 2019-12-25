package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.Employee;
import com.java.springboot.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployeesFromDB() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeDetailsFromDB(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElseGet(Employee::new);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Integer employeeId, Employee employee) {
        Employee employee1 = employeeRepository.findById(employeeId).orElseThrow(RuntimeException::new);
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());

        employeeRepository.save(employee1);
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}

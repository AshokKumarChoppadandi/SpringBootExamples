package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> getAllEmployeesFromDB();
    public Employee getEmployeeDetailsFromDB(Integer employeeId);
    public void addEmployee(Employee employee);
    public void updateEmployee(Integer employeeId, Employee employee);
    public void deleteEmployee(Integer employeeId);
}

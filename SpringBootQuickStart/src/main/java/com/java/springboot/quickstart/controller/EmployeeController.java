package com.java.springboot.quickstart.controller;

import com.java.springboot.quickstart.business.EmployeeService;
import com.java.springboot.quickstart.models.emp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/get_all_employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/get_employee/{employeeId}")
    public Employee getEmployee(@PathVariable (name = "employeeId") int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping(value = "/add_employee")
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping(value = "/update_employee/{employeeId}")
    public void updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        employeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping(value = "/delete_employee/{employeeId}")
    public List<Employee> deleteEmployee(@PathVariable int employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}

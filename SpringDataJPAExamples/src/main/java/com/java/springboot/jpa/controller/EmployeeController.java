package com.java.springboot.jpa.controller;

import com.java.springboot.jpa.entity.Employee;
import com.java.springboot.jpa.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/org_chart")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping(path = "/{dept}/get_add_employees_from_db")
    public List<Employee> getAllEmployeesFromDB(@PathVariable Integer dept) {
        //return iEmployeeService.getAllEmployeesForDeptFromDB(dept);\
        return iEmployeeService.getAllEmployeesFromDB();
    }

    @GetMapping(path = "/get_employee_from_db")
    public Employee getEmployeeFromDB(@RequestParam Integer employeeId) {
        return iEmployeeService.getEmployeeDetailsFromDB(employeeId);
    }

    @PostMapping(path = "/add_employee_to_db")
    public void addEmployeeToDB(@RequestBody Employee employee) {
        iEmployeeService.addEmployee(employee);
    }

    @PutMapping(path = "/update_employee_in_db")
    public void updateEmployeeInEB(@RequestParam Integer employeeId, @RequestBody Employee employee) {
        iEmployeeService.updateEmployee(employeeId, employee);
    }

    @DeleteMapping(path = "/delete_employee_from_db")
    public void deleteEmployeeFromDB(@RequestParam Integer employeeId) {
        iEmployeeService.deleteEmployee(employeeId);
    }
}

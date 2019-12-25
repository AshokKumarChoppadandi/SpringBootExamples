package com.java.springboot.jpa.controller;

import com.java.springboot.jpa.entity.Employee;
import com.java.springboot.jpa.entity.EmployeeInfo;
import com.java.springboot.jpa.repository.EmployeeInfoRepository;
import com.java.springboot.jpa.service.IEmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees/info")
public class EmployeeInfoController {

    @Autowired
    private IEmployeeInfoService iEmployeeInfoService;

    @GetMapping("/all")
    public List<EmployeeInfo> getAllEmployeesInfo() {
        return iEmployeeInfoService.getAllEmployeesInfo();
    }

    @PostMapping("/add_employee_info")
    public List<EmployeeInfo> addEmployeeInfo(
            @RequestParam Integer employeeId,
            @RequestParam String name,
            @RequestParam String dob,
            @RequestParam String contact,
            @RequestParam Integer salary
    ) {

        Employee employee = new Employee(employeeId, name, salary);
        EmployeeInfo info = new EmployeeInfo()
                .setId(employeeId)
                .setFull_name(name)
                .setDob(dob)
                .setContact(contact)
                .setEmployee(employee);

        return iEmployeeInfoService.addEmployeeInfo(info);
    }

    @GetMapping(path = "/{id}")
    public EmployeeInfo getEmployeeInfo(@PathVariable(name = "id") Integer employeeId) {
        return iEmployeeInfoService.getEmployeeInfo(employeeId);
    }
 }

package com.java.springboot.quickstart.controller;

import com.java.springboot.quickstart.business.DepartmentService;
import com.java.springboot.quickstart.dept.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * @RequestMapping - By default this considers as a GET Request.
     */

    /**
     * This Endpoint return all the topics as a List, which creates a new List every time when the REST endpoint is called.
     * @return : List of Departments
     */
    @RequestMapping("/static_departments1")
    public List<Department> getAllStaticDepartments() {
        return Arrays.asList(
                new Department(101, "CSE", "Computer Science and Engineering"),
                new Department(102, "IT", "Information Technology"),
                new Department(103, "ECE", "Electronics And Communication Engineering")
        );
    }

    /**
     * This Endpoint return all the topics as a List, which is already created in Business the Service Layer.
     * The Departments List is initialized on only and return the same List whenever the REST endpoint is called.
     * @return : List of Departments
     */
    @RequestMapping("/static_departments2")
    public List<Department> getAllStaticDepartments2() {
        return departmentService.getAllDepartments();
    }

    /**
     * This returns a Department details when the Department ID is passed as an argument.
     * Note: {id} - This is the PathVariable, ideally the name of the Path Variable and method Argument name should be same.
     * @param departmentId : Integer
     * @return : Department
     */
    @RequestMapping("/static_department/{id}") // Here 'id' is used as a Path Variable
    public Department getStaticDepartmentById(@PathVariable(name = "id") /*Here name = "id" is used to map the Path Variable to "departmentId"*/ int departmentId /* Here the Argument name is used "departmentId"*/) {
        return departmentService.getDepartmentDetailsById(departmentId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/departments")
    public void addDepartment(Department department) {
        departmentService.addDepartment(department);
    }


}

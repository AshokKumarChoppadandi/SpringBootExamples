package com.java.springboot.quickstart.controller;

import com.java.springboot.quickstart.business.DepartmentService;
import com.java.springboot.quickstart.models.dept.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //@RequestMapping("/static_departments1")
    @GetMapping(value = "/static_departments1")
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
    //@RequestMapping("/static_departments2")
    @GetMapping(value = "/static_departments2")
    public List<Department> getAllStaticDepartments2() {
        return departmentService.getAllDepartments();
    }

    /**
     * This returns a Department details when the Department ID is passed as an argument.
     * Note: {id} - This is the PathVariable, ideally the name of the Path Variable and method Argument name should be same.
     * Here name = "id" is used to map the Path Variable to "departmentId"
     * Here the Argument name is used "departmentId"
     * @param departmentId : Integer
     * @return : Department
     */
    //@RequestMapping("/static_department/{id}") // Here 'id' is used as a Path Variable
    @GetMapping(value = "/static_departments2/{id}")
    public Department getStaticDepartmentById(@PathVariable(name = "id") int departmentId) {
        return departmentService.getDepartmentDetailsById(departmentId);
    }

    /**
     * This REST endpoint takes the Department as an argument from the Request Body and adds to the Departments list.
     * @param department : Department
     */
    //@RequestMapping(method = RequestMethod.POST, value = "/add_department")
    @PostMapping("/add_department")
    public void addDepartment(@RequestBody Department department) {
        System.out.println("DEPARTMENT :: " + department);
        departmentService.addDepartment(department);
    }

    /**
     * This REST endpoint updates a Department details, it takes two arguments.
     *   1. The Department ID which need to be updated.
     *   2. The Department object - New Department Object after updating.
     * @param departmentId : Integer
     * @param department : Department
     */
    //@RequestMapping(method = RequestMethod.PUT, value = "/update_department/{id}")
    @PutMapping(value = "/update_department/{id}")
    public void updateDepartment(@PathVariable(name = "id") int departmentId, @RequestBody Department department) {
        departmentService.updateDepartmentDetails(departmentId, department);
    }


    /**
     * This REST endpoint delete a Department from the List when a Department ID is passed as an argument.
     * @param departmentId : Integer
     * @return : Returns List of Departments
     */
    @DeleteMapping("/delete_department/{id}")
    public List<Department> deleteDepartment(@PathVariable(name = "id") int departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }
}

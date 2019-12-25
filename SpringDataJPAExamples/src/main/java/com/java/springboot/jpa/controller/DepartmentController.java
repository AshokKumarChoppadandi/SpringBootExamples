package com.java.springboot.jpa.controller;

import com.java.springboot.jpa.entity.Department;
import com.java.springboot.jpa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/org_chart")
@ComponentScan({"com.java.springboot.jpa"})
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @GetMapping("/get_all_departments_from_db2")
    public List<Department> getAllDepartmentsFromDB() {
        return iDepartmentService.getAllDepartmentsFromDB();
    }

    @GetMapping("/get_department_from_db2")
    public Department getDepartmentFromDB(@RequestParam Integer deptId) {
        return iDepartmentService.getDepartmentDetailsFromDB(deptId);
    }

    @PostMapping("/insert_department2")
    public void insertDepartment(@Valid @RequestBody Department department) {
        iDepartmentService.addDepartmentToDB(department);
    }

    @PutMapping("/update_department_in_db2/{id}")
    public void updateDepartmentInDB(@PathVariable Integer id, @RequestBody Department department) {
        iDepartmentService.updateDepartmentInDB(id, department);
    }

    @DeleteMapping("/delete_department_from_db2/{id}")
    public void deleteDepartmentFromDB(@PathVariable Integer id) {
        iDepartmentService.deleteDepartmentFromDB(id);
    }

}

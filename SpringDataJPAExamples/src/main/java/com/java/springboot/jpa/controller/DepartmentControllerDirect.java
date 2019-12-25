package com.java.springboot.jpa.controller;

import com.java.springboot.jpa.entity.Department;
import com.java.springboot.jpa.repository.DepartmentRepository;
import com.java.springboot.jpa.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/org_chart")
@ComponentScan({"com.java.springboot.jpa"})
public class DepartmentControllerDirect {

    @Autowired
    private IDepartmentService iDepartmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    //@GetMapping(value = "/get_all_departments")
    @GetMapping(path = "/get_all_departments", produces = "application/json")
    public List<Department> getAllDepartments() {
        return iDepartmentService.getAllDepartments();
    }

    @GetMapping(path = "/get_department/{id}", produces = "application/json")
    public Department getDepartmentDetails(@PathVariable Integer id) {
        return iDepartmentService.getDepartmentDetails(id);
    }

    @PostMapping(path = "/add_department")
    public void addDepartment(@RequestBody Department department) {
        iDepartmentService.addDepartment(department);
    }

    @PutMapping(value = "/update_department/{id}")
    public void updateDepartment(@PathVariable Integer id, @RequestBody Department department) {
        iDepartmentService.updateDepartment(id, department);
    }

    @DeleteMapping(value = "/delete_department/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        iDepartmentService.deleteDepartment(id);
    }

    @GetMapping("/get_all_departments_from_db")
    public List<Department> getAllDepartmentsFromDB() {
        //return (List<Department>) departmentRepository.findAll();

        List<Department> departments = new ArrayList<>();
        //departmentRepository.findAll().forEach(department -> departments.add(department));
        // :: Java 8 Method Reference
        departmentRepository.findAll().forEach(departments::add);

        return departments;
    }

    @GetMapping("/get_department_from_db")
    public Department getDepartmentFromDB(@RequestParam Integer deptId) {
        return departmentRepository.findById(deptId).orElseGet(() -> new Department(null, null, null));
    }

    @PostMapping("/insert_department")
    public void insertDepartment(@Valid @RequestBody Department department) {
        departmentRepository.save(department);
    }

    @PutMapping("/update_department_in_db/{id}")
    public String updateDepartmentInDB(@PathVariable Integer id, @RequestBody Department department) {
        Department department1 = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("No Data Found"));
        department1.setName(department.getName());
        department1.setDescription(department.getDescription());

        departmentRepository.save(department1);

        return "Record Updated...!!!";
    }

    @DeleteMapping("/delete_department_from_db/{id}")
    public String deleteDepartmentFromDB(@PathVariable Integer id) {
        departmentRepository.deleteById(id);
        return "Record Deleted..!!!";
    }


}

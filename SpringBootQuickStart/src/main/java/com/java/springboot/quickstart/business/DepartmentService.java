package com.java.springboot.quickstart.business;

import com.java.springboot.quickstart.dept.Department;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {
    List<Department> departments = Arrays.asList(
            new Department(901, "CSE", "Computer Science and Engineering"),
            new Department(902, "IT", "Information Technology"),
            new Department(903, "ECE", "Electronics And Communication Engineering")
    );

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentDetailsById(int departmentId) {
        return departments.stream().filter(x -> x.getdId() == departmentId).findFirst().get();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
}

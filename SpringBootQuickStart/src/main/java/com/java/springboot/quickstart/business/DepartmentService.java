package com.java.springboot.quickstart.business;

import com.java.springboot.quickstart.models.dept.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DepartmentService {
    List<Department> departments = new ArrayList<>(Arrays.asList(
            new Department(901, "CSE", "Computer Science and Engineering"),
            new Department(902, "IT", "Information Technology"),
            new Department(903, "ECE", "Electronics And Communication Engineering")
    ));

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentDetailsById(int departmentId) {
        return departments.stream().filter(x -> x.getdId() == departmentId).findFirst().get();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void updateDepartmentDetails(int departmentId, Department department) {
        for (int i = 0; i < getDepartmentSize(); i++) {
            Department department1 = departments.get(i);
            if(department1.getdId() == departmentId) {
                System.out.println("Inside Update Condition...!!!");
                departments.set(i, department);
                return;
            }
        }
    }

    public List<Department> deleteDepartment(int departmentId) {
        /*
        for (int i = 0; i < getDepartmentSize() - 1; i++) {
            Department department = departments.get(i);
            if(department.getdId() == departmentId) {
                System.out.println("Inside Delete Condition");
                departments.remove(i);
                break;
            }
        }
        return departments;
        */

        // Using Java 8 functionality
        departments.removeIf(x -> x.getdId() == departmentId);
        return departments;
    }

    private int getDepartmentSize() {
        return departments.size();
    }
}

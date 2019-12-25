package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.Department;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartments();
    public Department getDepartmentDetails(Integer departmentId);
    public void addDepartment(Department department);
    public void updateDepartment(Integer departmentId, Department department);
    public void deleteDepartment(Integer departmentId);

    public List<Department> getAllDepartmentsFromDB();
    public Department getDepartmentDetailsFromDB(Integer departmentId);
    public void addDepartmentToDB(Department department);
    public void updateDepartmentInDB(Integer departmentId, Department department);
    public void deleteDepartmentFromDB(Integer departmentId);
}

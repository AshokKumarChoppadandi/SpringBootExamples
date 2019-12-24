package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.Department;

import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartments();
    public Department getDepartmentDetails(Integer departmentId);
    public void addDepartment(Department department);
    public void updateDepartment(Integer departmentId, Department department);
    public void deleteDepartment(Integer departmentId);
}

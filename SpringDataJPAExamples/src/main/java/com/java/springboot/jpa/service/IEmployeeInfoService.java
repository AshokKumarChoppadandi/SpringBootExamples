package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.EmployeeInfo;

import java.util.List;

public interface IEmployeeInfoService {
    public List<EmployeeInfo> getAllEmployeesInfo();
    public EmployeeInfo getEmployeeInfo(Integer employeeId);
    public List<EmployeeInfo> addEmployeeInfo(EmployeeInfo employeeInfo);
    //public void updateEmployeeInfo(Integer employeeId, EmployeeInfo employeeInfo);
    //public void deleteEmployeeInfo(Integer employeeId);
}

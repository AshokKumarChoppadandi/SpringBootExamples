package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.Employee;
import com.java.springboot.jpa.entity.EmployeeInfo;
import com.java.springboot.jpa.repository.EmployeeInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeInfoServiceImpl implements IEmployeeInfoService {

    @Autowired
    private EmployeeInfoRepository employeeInfoRepository;

    @Override
    public List<EmployeeInfo> getAllEmployeesInfo() {
        return employeeInfoRepository.findAll();
    }

    @Override
    public EmployeeInfo getEmployeeInfo(Integer employeeId) {
        return employeeInfoRepository.findById(employeeId).orElseGet(EmployeeInfo::new);
    }

    @Override
    public List<EmployeeInfo> addEmployeeInfo(EmployeeInfo employeeInfo) {
        employeeInfoRepository.save(employeeInfo);
        return employeeInfoRepository.findAll();
    }
}

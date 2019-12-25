package com.java.springboot.jpa.repository;

import com.java.springboot.jpa.entity.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Integer> {

}

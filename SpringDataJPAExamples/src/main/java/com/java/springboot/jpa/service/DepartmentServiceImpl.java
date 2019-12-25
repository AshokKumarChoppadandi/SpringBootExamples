package com.java.springboot.jpa.service;

import com.java.springboot.jpa.entity.Department;
import com.java.springboot.jpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private List<Department> departments = new ArrayList<>();

    @Override
    public List<Department> getAllDepartments() {
        return departments;
    }

    @Override
    public Department getDepartmentDetails(Integer departmentId) {
        if (departments.size() != 0)
            return departments.stream().filter(department -> department.getId().equals(departmentId)).findFirst().get();
        else
            return null;
    }

    @Override
    public void addDepartment(Department department) {
        departments.add(department);
    }

    @Override
    public void updateDepartment(Integer departmentId, Department department) {
        System.out.println("ID :: " + departmentId + ", DEPARTMENT :: " + department);
        int size = departments.size();
        if(size == 0) {
            System.out.println("INSIDE IF CONDITION");
            departments.add(department);
        } else {
            System.out.println("Inside ELSE Condition");
            for (int i = 0; i < size; i++) {
                System.out.println("Inside FOR loop");
                Department department1 = departments.get(i);
                if(department1.getId().equals(departmentId)) {
                    System.out.println("Inside Inner IF Condition");
                    departments.set(i, department);
                    return;
                }
            }
        }
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        departments.removeIf(department -> department.getId() == departmentId);
    }

    @Override
    public List<Department> getAllDepartmentsFromDB() {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);

        return departments;
    }

    @Override
    public Department getDepartmentDetailsFromDB(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElseGet(Department::new);
    }

    @Override
    public void addDepartmentToDB(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartmentInDB(Integer departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Error: No Record to Update with the given Id"));
        department1.setName(department.getName());
        department1.setDescription(department.getDescription());

        departmentRepository.save(department1);
    }

    @Override
    public void deleteDepartmentFromDB(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}

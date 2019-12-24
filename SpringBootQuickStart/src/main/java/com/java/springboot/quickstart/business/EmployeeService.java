package com.java.springboot.quickstart.business;

import com.java.springboot.quickstart.models.emp.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(111, "Choppadandi Ashok Kumar", 10000),
                    new Employee(112, "Ashok Kumar Choppadandi", 20000),
                    new Employee(113, "Ashok Choppadandi", 12000),
                    new Employee(114, "Ashok Kumar", 15000)
            )
    );

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int employeeId) {
        return employees.stream().filter(employee -> employee.getId() == employeeId).findFirst().get();
    }

    public List<Employee> addEmployee(Employee newEmployee) {
        employees.add(newEmployee);
        return employees;
    }

    public void updateEmployee(int employeeId, Employee employee) {
        int size = employees.size();
        for (int i = 0; i < size; i++) {
            Employee employee1 = employees.get(i);
            if(employee1.getId() == employeeId) {
                employees.set(i, employee);
                return;
            }
        }
    }

    public List<Employee> deleteEmployee(int employeeId) {
        employees.removeIf(employee -> employee.getId() == employeeId);
        return employees;
    }
}

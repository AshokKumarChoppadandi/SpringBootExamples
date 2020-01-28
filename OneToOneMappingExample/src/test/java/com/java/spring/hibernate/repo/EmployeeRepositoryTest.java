package com.java.spring.hibernate.repo;

import com.java.spring.hibernate.entity.Department;
import com.java.spring.hibernate.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class EmployeeRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DirtiesContext
    public void insertEmployeeTest() {

        Employee actualResult = insertOneEmployee();
        logger.info("Employee with Department :: {}", actualResult);

        assertNotNull(actualResult.getId());
        assertEquals(actualResult.getName(), "Jack");
        assertNotNull(actualResult.getDepartment().getDeptId());
    }

    @Test
    @DirtiesContext
    public void getAllEmployeesTest() {
        insertOneEmployee();
        List<Employee> employees = employeeRepository.getAllEmployees();
        logger.info("All Employees with Department :: {}", employees);

        assertEquals(employees.size(), 1);

    }

    @Test
    @DirtiesContext
    public void findByIdTest() {
        Employee employee = insertOneEmployee();
        Integer id = employee.getId();

        Employee employee1 = employeeRepository.findById(id);
        logger.info("Employee with ID :: {} = {}", id, employee1);

        assertEquals(employee.getId(), employee1.getId());
        assertEquals("Jack", employee1.getName());
        assertEquals(15000, employee1.getSalary());
        assertEquals(getFormattedDate("2018-01-01"), employee1.getJoiningDate());
        assertEquals(1, employee1.getDepartment().getDeptId());
        assertEquals("HR", employee1.getDepartment().getDeptName());
        assertEquals("HUMAN RESOURCES", employee1.getDepartment().getDeptType());


    }

    @Test
    @DirtiesContext
    public void findByINameTest() {
        Employee employee = insertOneEmployee();

        String employeeName = "Jack";
        Employee employee1 = employeeRepository.findByName(employeeName);
        logger.info("Employee with  Name :: {} = {}", employeeName, employee1);

        assertEquals(employee.getId(), employee1.getId());
        assertEquals("Jack", employee1.getName());
        assertEquals(15000, employee1.getSalary());
        assertEquals(getFormattedDate("2018-01-01"), employee1.getJoiningDate());
        assertEquals(1, employee1.getDepartment().getDeptId());
        assertEquals("HR", employee1.getDepartment().getDeptName());
        assertEquals("HUMAN RESOURCES", employee1.getDepartment().getDeptType());
    }

    private Employee insertOneEmployee() {
        Department department = new Department("HR", "HUMAN RESOURCES");

        String dateString = "2018-01-01";
        Date joiningDate = null;
        try {
            joiningDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee employee = new Employee("Jack", 15000, joiningDate, department);

        return employeeRepository.insertEmployee(employee);
    }

    private Date getFormattedDate(String dateString) {
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}

package com.java.spring.hibernate;

import com.java.spring.hibernate.entity.Department;
import com.java.spring.hibernate.entity.Employee;
import com.java.spring.hibernate.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class OneToOneMappingExampleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Department department = new Department("IT", "PRODUCT DEVELOPMENT");
		String dateString = "2019-01-01";
		Date joiningDate = dateFormat.parse(dateString);
		Employee employee = new Employee("Adam", 10000, joiningDate, department);

		employeeRepository.insertEmployee(employee);

		Employee employee1 = employeeRepository.findById(1);
		logger.info("EMPLOYEE :: {}", employee1);*/

	}

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingExampleApplication.class, args);
	}

}

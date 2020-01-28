/**
 * Created by Ashok Kumar Choppadandi on 2019/12/26
 * 		- Added OneToOne Mapping
 * Modified on 2020/01/28
 * 		- Added Bi-directional Mapping
 */

package com.java.spring.hibernate;

import com.java.spring.hibernate.entity.Department;
import com.java.spring.hibernate.entity.EmployeeLocker;
import com.java.spring.hibernate.entity.EmployeeLockerBidirectional;
import com.java.spring.hibernate.repo.EmployeeLockerBidirectionalRepository;
import com.java.spring.hibernate.repo.EmployeeLockerRepository;
import com.java.spring.hibernate.repo.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class OneToOneMappingExampleApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeLockerBidirectionalRepository bidirectionalRepository;

	@Autowired
	private EmployeeLockerRepository lockerRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		/*Department department = new Department("IT", "PRODUCT DEVELOPMENT");
		String dateString = "2019-01-01";
		Date joiningDate = dateFormat.parse(dateString);
		Employee employee = new Employee("Adam", 10000, joiningDate, department);

		employeeRepository.insertEmployee(employee);

		Employee employee1 = employeeRepository.findById(1);
		logger.info("EMPLOYEE :: {}", employee1);*/

		// Code added to test Bidirectional Mapping
		Department department = new Department("IT", "PRODUCT DEVELOPMENT");
		EmployeeLocker locker = new EmployeeLocker(9876543210L);

		String dateString = "2019-01-01";
		Date joiningDate = dateFormat.parse(dateString);
		EmployeeLockerBidirectional employee = new EmployeeLockerBidirectional("Adam", 10000, joiningDate, department, locker);

		EmployeeLockerBidirectional result = bidirectionalRepository.insertEmployee(employee);
		logger.info("RESULT AFTER INSERT :: {}", result);
		logger.info("RESULT AFTER INSERT, DEPARTMENT :: {}", result.getDepartment());
		logger.info("RESULT AFTER INSERT, LOCKER :: {}", result.getLocker());

		EmployeeLockerBidirectional employee1 = bidirectionalRepository.findById(1);
		logger.info("EMPLOYEE LOCKER BIDIRECTIONAL :: {}", employee1);
		logger.info("EMPLOYEE LOCKER 1 :: {}", employee1.getLocker());

		EmployeeLocker locker1 = lockerRepository.findById(1);
		logger.info("LOCKER 2 :: {}", locker1);
		logger.info("EMPLOYEE 2 :: {}", locker1.getEmployee());
	}

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingExampleApplication.class, args);
	}

}

/**
package com.java.spring;

import com.java.spring.basics.coupled.loosely.BinarySearchLooselyCoupled;
import com.java.spring.basics.coupled.loosely.withannotations.BinarySearchWithAnnotations;
import com.java.spring.basics.coupled.tightly.BinarySearchTightlyCoupled;
import com.java.spring.basics.sort.BubbleSort;
import com.java.spring.basics.sort.QuickSort;
import com.java.spring.entity.Person;
import com.java.spring.entity.PersonEntity;
import com.java.spring.jdbc_to_jpa.dao.PersonJdbcDAO;
import com.java.spring.jdbc_to_jpa.dao.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBasicsApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDAO personJdbcDAO;

	@Autowired
	private PersonJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {

		// Using JdbcTemplate
		List<Person> personList = personJdbcDAO.findAll();
		//for (Person person : personList) {
		//	logger.info(person.toString());
		//}
		logger.info("Persons :: {}", personList);

		Person person = personJdbcDAO.findById(1001);
		logger.info("Person with Id 1001 is :: {}", person);

		List<Person> personList1 = personJdbcDAO.findAllByLocation("HYDERABAD");
		logger.info("Persons withs HYDERABAD location :: {}", personList1);

		Integer affectedRows = personJdbcDAO.deleteById(1005);
		logger.info("Rows deleted with id 1005 :: {}", affectedRows);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String dateString1 = "1985-12-04 02:25:30.456";

		Date birthDate1 = dateFormat.parse(dateString1);

		Person person1 = new Person(1006, "Virat Kohli", "BANGALORE", birthDate1);
		Integer affectedRows1 = personJdbcDAO.insertPerson(person1);
		logger.info("Number of Rows inserted :: {}", affectedRows1);

		String dateString2 = "1987-04-20 08:20:15.335";
		Date birthDate2 = dateFormat.parse(dateString2);
		Person person2 = new Person(1002, "MS DHONI", "CHENNAI", birthDate2);

		Integer affectedRows2 = personJdbcDAO.updatePerson(person2);
		logger.info("Number of rows updated :: {}", affectedRows2);

		List<Person> personList2 = personJdbcDAO.findAll2();
		logger.info("Persons with custom RowMapper :: {}", personList2);

		List<Person> personList3 = personJdbcDAO.findAll3();
		logger.info("Persons with custom RowMapper using LAMBDA function :: {}", personList3);
	}

	public static void main(String[] args) {

		// 1. Tightly Coupled vs Loosely Coupled
		// ---------------------------------------------------------------------------------
		int searchElement = Integer.parseInt(args[0]);
		int[] numbers = new int[] {6, 9, 10, 4, 7, 1};

		*/
		/**
		 * Tightly Coupled Example
		 * Here everything is TIGHTLY COUPLED
		 * i.e., The Sorting Algorithm using here is tightly coupled with Binary Search.
		 * If in future, we want to change the Sorting algorithm then we should change the Algorithm implementation.
		 */
		/**

		BinarySearchTightlyCoupled binarySearch1 = new BinarySearchTightlyCoupled();
		System.out.println(String.format("%s found at index :: %s", searchElement, binarySearch1.search(numbers, searchElement)));

		// 1. Loosely Coupled Example - Using Bubble Sort for data the elements of an Array
		BinarySearchLooselyCoupled binarySearch2 = new BinarySearchLooselyCoupled(new BubbleSort());
		System.out.println(String.format("%s found at index :: %s", searchElement, binarySearch2.search(numbers, searchElement)));

		// 2. Loosely Coupled Example - Using Quick Sort for data the elements of an Array
		BinarySearchLooselyCoupled binarySearch3 = new BinarySearchLooselyCoupled(new QuickSort());
		System.out.println(String.format("%s found at index :: %s", searchElement, binarySearch3.search(numbers, searchElement)));

		*/
		/* --------------------------------------------------------------------------------- */
		/**
		 * Here, the programmer has to create these beans (Objects) and add as the dependency (Wiring)
		 * Example: The programmer has to create the Sort algorithm and pass the object as an argument to another class
		 *
		 * Sort sortAlgorithm = new BubbleSort();	// Creating the beans / objects
		 * BinarySearchLooselyCoupled binarySearch2 = new BinarySearchLooselyCoupled(sortAlgorithm);	// Wiring / Adding a Dependency
		 *
		 * This will be easy for the programmer but in real time, if it consists of some thousands of objects / beans needs to be created, there comes the problem.
		 * But fortunately, SPRING FRAMEWORK helps in wiring these beans / objects and also their dependencies which is called as Dependency Injection
		 * @AutoWired Annotation is used for Dependency Injection in Spring Framework.
		 *
		 * To make SPRING FRAMEWORK help us we need to tell the following things to spring:
		 * 		1. What are the beans to be created ?
		 * 		2. What are the dependencies for a bean ?
		 * 		3. Where to search the beans ?
		 *
		 * Answers:
		 * 		1. Adding @Component to the Class, Spring identifies it as a Bean.
		 * 		2. Adding @AutoWired to the Objects, Spring identifies it as a Dependency
		 * 		3. Adding @ComponentScan to the Class, Spring identifies where to search for the beans.
		 *
		 * 	Note: Spring Boot by default / automatically scans / searches where the main class is present.
		 */

		/**
		 * Now, the Spring Framework helps us in creating these Objects and dependencies after adding the Annotations
		 * For Example, now we'll not create any objects for BinarySearch and Sort classes.
		 * Instead, Spring gives us these instances / objects with the help of Spring APPLICATION CONTEXT
		 * APPLICATION CONTEXT, stores / maintain all the available beans and provide to the user / programmer.
		 */
		/**
		// Getting / Creating the ApplicationContext
		ApplicationContext applicationContext = SpringApplication.run(SpringBasicsApplication.class, args);

		// Getting the beans from Spring ApplicationContext
		BinarySearchWithAnnotations binarySearchWithAnnotations = applicationContext.getBean(BinarySearchWithAnnotations.class);
		System.out.println(String.format("%s found at index :: %s", searchElement, binarySearchWithAnnotations.search(numbers, searchElement)));

	}
}
*/

package com.java.spring;

import com.java.spring.entity.Course;
import com.java.spring.entity.PersonEntity;
import com.java.spring.jdbc_to_jpa.dao.PersonEntityManagerRepository;
import com.java.spring.jpa.entitymanager.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
@Transactional
public class SpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonEntityManagerRepository repository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {

		// Using JPA - EntityManager - Person
		PersonEntity personEntity = repository.findById(1001);
		logger.info("Using JPA, Person with id 1001 :: {}", personEntity);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String dateString = "1990-09-04 10:30:45.345";

		PersonEntity personEntity1 = new PersonEntity(1001, "ROHIT SHARMA", "BOMBAY", dateFormat.parse(dateString));
		logger.info("Updated Record :: {}", repository.update(personEntity1));

		PersonEntity personEntity2 = new PersonEntity("DINESH KARTHIK", "DELHI", dateFormat.parse(dateString));
		logger.info("Inserted Record :: {}", repository.insert(personEntity2));

		PersonEntity personEntity3 = repository.findById(1003);
		repository.delete(personEntity3);
		logger.info("Persons after deleting 1003 :: {}", repository.findById(1003));

		repository.deleteById(1001);
		logger.info("Persons after deleting 1001 :: {}", repository.findById(1001));

		List<PersonEntity> personEntities = repository.findAll();
		logger.info("Persons :: {}", personEntities);

		List<PersonEntity> personEntities1 = repository.findAllUsingNamedQuery();
		logger.info("Persons :: {}", personEntities1);

		// Using JPA - EntityManager - Course
		Course course = courseRepository.findById(901);
		logger.info("Course with ID 1 :: {}", course);

		Course course1 = new Course("Scala");
		logger.info("{} is inserted", courseRepository.save(course1));

		courseRepository.deleteById(901);
		logger.info("Course with id :: 901 is deleted");

		logger.info("Course with Auto Update Feature :: {}", courseRepository.automaticUpdateFeatureOfEntityManager("Python"));

		//Course course2 = courseRepository.save(new Course(910, "This is a Test Course"));
		//course2.setCourseName(course2.getCourseName() + " - Updated");

		Course course00 = courseRepository.findById(905);
		course00.setCourseName("Update Java");
		logger.info("Course with Updated Timestamp :: {}", courseRepository.updateCourse(course00));

		logger.info("GET_ALL_COURSES_USING_QUERY :: {}", courseRepository.findAllByUsingNamedQuery());

		logger.info("GET_ALL_COURSES_USING_NAMED_QUERIES :: {}", courseRepository.findAllByUsingNamedQueries());

		logger.info("GET_ALL_COURSES_USING_NAMED_QUERIES_WITH_LIKE :: {}", courseRepository.findAllByUsingNamedQueriesWithLike());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}


}

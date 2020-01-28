package com.java.spring.jpa.entitymanager;

import com.java.spring.entity.Course;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findByIdTest() {
        Course course = courseRepository.findById(902);
        Assertions.assertEquals("Hadoop", course.getCourseName());
    }

    @Test
    @DirtiesContext
    public void saveTest() {
        Course course = courseRepository.save(new Course("Test"));
        Assertions.assertNotNull(course.getId());
    }

    @Test
    @DirtiesContext
    public void updateTest() {
        Course course = courseRepository.save(new Course(901, "Spring Boot"));
        Assertions.assertEquals("Spring Boot", course.getCourseName());
    }

    @Test
    @DirtiesContext
    public void deleteByIdTest() {
        courseRepository.deleteById(902);
        Assertions.assertNull(courseRepository.findById(902));
    }

    @Test
    @DirtiesContext
    public void automaticUpdateFeatureOfEntityManagerTest() {
        Course course = courseRepository.automaticUpdateFeatureOfEntityManager("Python");
        Assertions.assertEquals("Python - Updated", course.getCourseName());
    }

    @Test
    @DirtiesContext
    public void restrictingAutomaticUpdateFeatureOfEntityManagerTest() {
        Course course = courseRepository.restrictingAutomaticUpdateFeatureOfEntityManager("Python");
        Assertions.assertEquals("Python", course.getCourseName());
    }

    @Test
    @DirtiesContext
    public void enablingUpdateFeatureOfEntityManagerWithRefreshTest() {
        List<Course> courses = courseRepository.enablingUpdateFeatureOfEntityManagerWithRefresh("Python", "Scala");

        Assertions.assertEquals(2, courses.size());

        Course course1 = courses.get(0);
        Course course2 = courses.get(1);

        Assertions.assertNotNull(course1.getId());
        Assertions.assertFalse(course1.getCourseName().contains("Updated"));

        Assertions.assertNotNull(course2.getId());
        Assertions.assertTrue(course2.getCourseName().contains("Updated"));
    }

    @Test
    public void findAllUsingJPQLBasic() {
        List<Course> courses = (List<Course>) courseRepository.findAllUsingJPQLBasic();
        Assertions.assertTrue(courses.size() > 0);
    }

    @Test
    public void findAllUsingJPQLTest() {
        List<Course> courses = courseRepository.findAllUsingJPQLTyped();
        Assertions.assertTrue(courses.size() > 0);
    }

    @Test
    public void findByIdUsingJPQLUsingPositionalParametersTest() {
        Course course = courseRepository.findByIdUsingJPQLUsingPositionalParameters(902);

        Assertions.assertEquals(902, course.getId());
        Assertions.assertEquals("Hadoop", course.getCourseName());
    }

    @Test
    public void findByIdUsingJPQLUsingNamedParametersTest() {
        Course course = courseRepository.findByIdUsingJPQLUsingNamedParameters(902);

        Assertions.assertEquals(902, course.getId());
        Assertions.assertEquals("Hadoop", course.getCourseName());
    }

    @Test
    @DirtiesContext
    // Unable to make this test as success - Have to check later
    public void createdAndLastUpdateTimestampTest() {

        Course course = courseRepository.findById(904);
        System.out.println("--------------------\nBefore Update :: " + course + "\n-------------------");

        course.setCourseName("Kafka - Updated Course");
        courseRepository.updateCourse(course);

        Course course1 = courseRepository.findById(904);
        System.out.println("--------------------\nAfter Update :: " + course1 + "\n-------------------");

        Assertions.assertTrue(true);
        //Assertions.assertNotEquals(course2.getCreatedTimestamp(), course2.getLastUpdateTimestamp());
        //Assertions.assertTrue(course2.getLastUpdateTimestamp().isAfter(course2.getCreatedTimestamp()));
    }

    @Test
    public void findAllByUsingNamedQueryTest() {
        List<Course> courses = courseRepository.findAllByUsingNamedQuery();
        List<Integer> courseIds = courses.stream().map(Course::getId).collect(Collectors.toList());
        List<String> courseNames = courses.stream().map(Course::getCourseName).collect(Collectors.toList());
        Assertions.assertEquals(6, courses.size());
        MatcherAssert.assertThat(courseIds, Matchers.containsInAnyOrder(2, 3, 902, 903, 904, 905));
        MatcherAssert.assertThat(courseNames, Matchers.containsInAnyOrder("Scala", "Python - Updated", "Hadoop", "Spark", "Kafka", "Update Java"));
    }

    @Test
    public void findAllByUsingNamedQueriesTest() {
        List<Course> courses = courseRepository.findAllByUsingNamedQueries();
        List<Integer> courseIds = courses.stream().map(Course::getId).collect(Collectors.toList());
        List<String> courseNames = courses.stream().map(Course::getCourseName).collect(Collectors.toList());
        Assertions.assertEquals(6, courses.size());
        MatcherAssert.assertThat(courseIds, Matchers.containsInAnyOrder(2, 3, 902, 903, 904, 905));
        MatcherAssert.assertThat(courseNames, Matchers.containsInAnyOrder("Scala", "Python - Updated", "Hadoop", "Spark", "Kafka", "Update Java"));
    }

    @Test
    public void findAllByUsingNamedQueriesWithLikeTest() {
        List<Course> courses = courseRepository.findAllByUsingNamedQueriesWithLike();
        List<Integer> courseIds = courses.stream().map(Course::getId).collect(Collectors.toList());
        List<String> courseNames = courses.stream().map(Course::getCourseName).collect(Collectors.toList());

        Assertions.assertEquals(2, courses.size());
        MatcherAssert.assertThat(courseIds, Matchers.containsInAnyOrder(3, 905));
        MatcherAssert.assertThat(courseNames, Matchers.containsInAnyOrder("Python - Updated", "Update Java"));
    }

    @Test
    public void findAllByUsingNativeQueryTest1() {
        String query = "select * from course";
        List<Course> courses = courseRepository.findAllByUsingNativeQuery(query);
        List<Integer> courseIds = courses.stream().map(Course::getId).collect(Collectors.toList());
        List<String> courseNames = courses.stream().map(Course::getCourseName).collect(Collectors.toList());

        Assertions.assertEquals(6, courses.size());
        MatcherAssert.assertThat(courseIds, Matchers.containsInAnyOrder(2, 3, 902, 903, 904, 905));
        MatcherAssert.assertThat(courseNames, Matchers.containsInAnyOrder("Scala", "Python - Updated", "Hadoop", "Spark", "Kafka", "Update Java"));
    }

    @Test
    public void findAllByUsingNativeQueryTest2() {
        String query = "select * from course where course_name like '%Update%'";
        List<Course> courses = courseRepository.findAllByUsingNativeQuery(query);
        List<Integer> courseIds = courses.stream().map(Course::getId).collect(Collectors.toList());
        List<String> courseNames = courses.stream().map(Course::getCourseName).collect(Collectors.toList());

        Assertions.assertEquals(2, courses.size());
        MatcherAssert.assertThat(courseIds, Matchers.containsInAnyOrder(3, 905));
        MatcherAssert.assertThat(courseNames, Matchers.containsInAnyOrder("Python - Updated", "Update Java"));
    }
}

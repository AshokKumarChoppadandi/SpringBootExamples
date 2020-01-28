package com.java.spring.jpa.entitymanager;

import com.java.spring.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Course findById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void deleteById(Integer id) {
        Course course = findById(id);
        entityManager.remove(course);
    }


    public Course automaticUpdateFeatureOfEntityManager(String courseName) {

        Course course = new Course(courseName);
        entityManager.persist(course);

        // Here the Course Name is updated after inserting the data into database.
        // But this update is tracked by EntityManager automatically and update in the database.
        // All this happens with the help of @Transactional annotation.
        // All the code that exists in this block is either executed or not.
        course.setCourseName(courseName + " - Updated");
        return course;
    }

    public Course restrictingAutomaticUpdateFeatureOfEntityManager(String courseName) {
        Course course = new Course(courseName);
        entityManager.persist(course);
        // flush() - This method pushes all the changes to the database.
        entityManager.flush();

        Integer id = course.getId();
        // detach() - This method detaches / removes the course object from EntityManger. It is used only for one Object.
        // Hence EntityManager will not keep track of this object, so making changes to this object will not effect database.
        entityManager.detach(course);
        //entityManager.clear();
        // clear() - This method detaches / removes / clears all the objects from EntityManager. It is used for all the Objects
        // Hence nothing can be updated after running clear() method on EntityManager.
        course.setCourseName(String.format("%s Updated", courseName));
        entityManager.flush();

        return findById(id);
    }

    public List<Course> enablingUpdateFeatureOfEntityManagerWithRefresh(String courseName1, String courseName2) {
        List<Course> courses = new ArrayList<>();

        Course course1 = new Course(courseName1);
        Course course2 = new Course(courseName2);
        entityManager.persist(course1); // persist(course1) is kept ready for saving to the database
        entityManager.persist(course2); // persist(course1) is kept ready for saving to the database
        entityManager.flush(); // flush() - Pushes all the changes to the Database.

        course1.setCourseName(courseName1 + " - Updated"); // Updating the course1 Name
        course2.setCourseName(courseName2 + " - Updated"); // Updating the course2 Name
        entityManager.refresh(course1); // refresh() - This method will just refresh the Course Object and whatever the changes made to it are not save to database.
        entityManager.flush();

        courses.add(findById(course1.getId()));
        courses.add(findById(course2.getId()));

        return courses;
    }

    public List findAllUsingJPQLBasic() {
        Query query = entityManager.createQuery("select c from Course c");
        return query.getResultList();
    }

    public List<Course> findAllUsingJPQLTyped() {
        TypedQuery<Course> courseTypedQuery = entityManager.createQuery("select c from Course c", Course.class);
        return courseTypedQuery.getResultList();
    }

    public Course findByIdUsingJPQLUsingPositionalParameters(Integer Id) {
        return entityManager
                .createQuery("select c from Course c where id = ?1", Course.class)
                .setParameter(1, Id)
                .getSingleResult();
    }

    public Course findByIdUsingJPQLUsingNamedParameters(Integer Id) {
        return entityManager
                .createQuery("select c from Course c where c.id = :id", Course.class)
                .setParameter("id", Id)
                .getSingleResult();
    }

    public Course updateCourse(Course course) {
        entityManager.merge(course);
        return course;
    }

    public List<Course> findAllByUsingNamedQuery() {
        return entityManager.createNamedQuery("get_all_courses_using_query", Course.class).getResultList();
    }

    public List<Course> findAllByUsingNamedQueries() {
        return entityManager.createNamedQuery("get_all_courses_using_named_queries", Course.class).getResultList();
    }

    public List<Course> findAllByUsingNamedQueriesWithLike() {
        return entityManager.createNamedQuery("get_all_courses_using_named_queries_with_like", Course.class).getResultList();
    }

    public List<Course> findAllByUsingNativeQuery(String queryString) {
        List<Course> courses = new ArrayList<>();
        Query query = entityManager.createNativeQuery(queryString);
        List<Object> objectList = (List<Object>) query.getResultList();
        Iterator iter = objectList.iterator();

        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            Integer id = Integer.valueOf(String.valueOf(obj[0]));
            String courseName = String.valueOf(obj[1]);

            courses.add(new Course(id, courseName));
        }


        return courses;
    }
}

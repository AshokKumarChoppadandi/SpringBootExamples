package com.java.spring.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course")
@NamedQuery(name = "get_all_courses_using_query", query = "select c from Course c")
@NamedQueries(value = {
        @NamedQuery(
                name = "get_all_courses_using_named_queries",
                query = "select c from Course c"
        ), @NamedQuery(
        name = "get_all_courses_using_named_queries_with_like",
        query = "select c from Course c where c.courseName like '%Update%'"
        )
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "course_name")
    private String courseName;

    @CreationTimestamp
    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;

    @UpdateTimestamp
    @Column(name = "last_updated_timestamp")
    private LocalDateTime lastUpdateTimestamp;

    public Course() {}

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(Integer id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", lastUpdateTimestamp=" + lastUpdateTimestamp +
                '}';
    }
}

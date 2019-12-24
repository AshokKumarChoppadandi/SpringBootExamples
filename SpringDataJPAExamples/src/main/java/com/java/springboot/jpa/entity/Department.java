package com.java.springboot.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments", schema = "springboot")
public class Department {
    private Integer id;
    private String name;
    private String description;

    public Department() {
    }

    public Department(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

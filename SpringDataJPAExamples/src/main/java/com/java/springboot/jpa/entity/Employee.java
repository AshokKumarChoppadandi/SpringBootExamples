package com.java.springboot.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees", schema = "springboot")
public class Employee {
    @Id
    @Column(name = "emp_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private Integer salary;
    /*@ManyToOne
    private Department department;*/

    public Employee() {}

    public Employee(Integer id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

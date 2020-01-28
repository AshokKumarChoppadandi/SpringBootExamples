package com.java.spring.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee_bidirectional")
public class EmployeeLockerBidirectional implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "joining_date")
    private Date joiningDate;

    /**
     * By default @OneToOne Annotation fetch the Department details even if those details are not details called as EAGER Fetch.
     * By default the value is FetchType.EAGER
     * This can be controlled by using the FetchType.LAZY
     *
     * Department details are fetch from Database table only if needed.
     */
    @OneToOne(fetch = FetchType.LAZY)
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lockerNumber", unique = true)
    private EmployeeLocker locker;

    public EmployeeLockerBidirectional() {}

    public EmployeeLockerBidirectional(String name, Integer salary, Date joiningDate, Department department, EmployeeLocker locker) {
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.department = department;
        this.locker = locker;
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

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeLocker getLocker() {
        return locker;
    }

    public void setLocker(EmployeeLocker locker) {
        this.locker = locker;
    }

    @Override
    public String toString() {
        return "EmployeeLockerBidirectional{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", department=" + department +
                ", locker=" + locker +
                '}';
    }
}

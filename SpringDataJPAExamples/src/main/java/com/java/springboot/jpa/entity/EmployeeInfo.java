package com.java.springboot.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees_info", schema = "springboot")
public class EmployeeInfo {
    @Id
    @Column(name = "id")
    private Integer id;
    private String full_name;
    private String dob;
    private String contact;

    /**
     * @OneToOne - This Annotation tell the Spring to join the Employee_Info with Employee table.
     * CascadeType.ALL - This helps in creating the Employee record in Employee Table, if not provided error is thrown
     * @JoinColumnName - This Annotation tell the Spring, which column from tables to use for joining.
     *                   The first argument, name : This is the name of the Column from EmployeeInfo table. (This is the FOREIGN KEY column in EmployeeInfo table)
     *                   The Second argument, referencedColumnName : This is the name of the Column from Employee Table. (This is the PRIMARY KEY column in Employee table)
     * Note: If the first argument in @JoinColumnName annotation is given a different column name, then a new column is created with the given name in the EmployeeInfo table.
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    public EmployeeInfo() {
    }

    public Integer getId() {
        return id;
    }

    public EmployeeInfo setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFull_name() {
        return full_name;
    }

    public EmployeeInfo setFull_name(String full_name) {
        this.full_name = full_name;
        return this;
    }

    public String getDob() {
        return dob;
    }

    public EmployeeInfo setDob(String dob) {
        this.dob = dob;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public EmployeeInfo setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public EmployeeInfo setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", dob='" + dob + '\'' +
                ", contact='" + contact + '\'' +
                ", employee=" + employee +
                '}';
    }
}

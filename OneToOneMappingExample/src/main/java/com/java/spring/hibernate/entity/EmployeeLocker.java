package com.java.spring.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_locker")
public class EmployeeLocker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locker_id")
    private Integer lockerNumber;

    @Column(name = "contact_number")
    private Long contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeLockerBidirectional employee;

    public EmployeeLocker() {
    }

    public EmployeeLocker(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getLockerNumber() {
        return lockerNumber;
    }

    public void setLockerNumber(Integer lockerNumber) {
        this.lockerNumber = lockerNumber;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public EmployeeLockerBidirectional getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeLockerBidirectional employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeLocker{" +
                "lockerNumber=" + lockerNumber +
                ", contactNumber=" + contactNumber +
                ", employee=" + employee +
                '}';
    }
}

package com.java.springboot.sms.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cricketers", schema = "springboot")
public class CricketerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "skill", nullable = false)
    private String skill;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    public CricketerEntity() {}

    public CricketerEntity(String skill, String firstName, String lastName) {
        this.skill = skill;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public CricketerEntity(Integer id, String skill, String firstName, String lastName) {
        this.id = id;
        this.skill = skill;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CricketerEntity that = (CricketerEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(skill, that.skill) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, firstName, lastName);
    }

    @Override
    public String toString() {
        return "CricketerEntity{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

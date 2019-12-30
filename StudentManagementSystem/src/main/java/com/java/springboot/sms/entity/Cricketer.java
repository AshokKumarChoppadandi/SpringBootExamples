package com.java.springboot.sms.entity;

import java.util.Objects;

public class Cricketer {
    private Integer id;
    private String skill;
    private String firstName;
    private String lastName;

    public Cricketer() {
    }

    public Cricketer(String skill, String firstName, String lastName) {
        this.skill = skill;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Cricketer(Integer id, String skill, String firstName, String lastName) {
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
        Cricketer cricketer = (Cricketer) o;
        return Objects.equals(id, cricketer.id) &&
                Objects.equals(skill, cricketer.skill) &&
                Objects.equals(firstName, cricketer.firstName) &&
                Objects.equals(lastName, cricketer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, skill, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Cricketer{" +
                "id=" + id +
                ", skill='" + skill + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

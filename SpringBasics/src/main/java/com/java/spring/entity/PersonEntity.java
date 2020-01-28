package com.java.spring.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * @Entity - This Annotation is used to define this Class is Table in Database.
 */
@Entity
/**
 * // @Table - This Annotation is used define a table name in the Database.
 * // @Table(name = "person") is Optional, If the name of the TABLE is different from the CLASS name, then the table name can be defined using name = "<TABLE_NAME>"
 */
@Table(name = "person")
@NamedQuery(name = "find_all_persons_using_named_query", query = "select p from PersonEntity p") // NamedQuery implementation on an Entity
public class PersonEntity {
    /**
     * @Id - This Annotation is used to define the Primary key for the Table.
     * @GeneratedValue - This Annotation is used to define the Primary Key Type
     *      strategy = GenerationType.SEQUENCE - Spring / Hibernate generates the Primary Key values in SEQUENCE order. i.e., Incremental Order
     * @Column - This Annotation is used to define the Column Name in the Table.
     *      nullable = false - This tell the Spring / Hibernate, that this column will not accept NULL values. i.e., Similar to NOT NULL in Database
     *      unique = true - This tell the Spring / Hibernate, that this column should have only UNIQUE values. i.e., Similar to UNIQUE or PRIMARY KEY in Database
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "birth_date")
    private Date birthDate;

    public PersonEntity() {}

    public PersonEntity(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }

    public PersonEntity(Integer id, String name, String location, Date birthDate) {
        super();
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

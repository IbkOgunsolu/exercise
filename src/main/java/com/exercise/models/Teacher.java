package com.exercise.models;

import javax.persistence.*;

/**
 * Created by Ibukun.Ogunsolu on 7/1/2017.
 */
@Entity
@Table(name="teacher",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Teacher {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Person person;
    @Column(name="designation", length=200, nullable=true)
    private String designation;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

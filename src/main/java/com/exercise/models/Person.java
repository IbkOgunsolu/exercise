package com.exercise.models;

import javax.persistence.*;

/**
 * Created by Ibukun.Ogunsolu on 7/1/2017.
 */
@Entity
@Table(name="person",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @Column(name="surname", length=200, nullable=true)
    private String surname;
    @Column(name="first_name", length=200, nullable=true)
    private String firstName;
    @Column(name="other_names", length=200, nullable=true)
    private String otherNames;
    @ManyToOne(cascade = CascadeType.ALL)
    private Contact contact;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}

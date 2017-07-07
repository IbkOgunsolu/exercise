package com.exercise.models;

import javax.persistence.*;

/**
 * Created by Ibukun.Ogunsolu on 7/2/2017.
 */
@Entity
@Table(name="contact",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true, length=11)
    private int id;
    @Column(name="email_address", length=200, nullable=true)
    private String emailAddress;
    @Column(name="phone_number", length=200, nullable=true)
    private String phoneNumber;
    @Column(name="address_line1", length=200, nullable=true)
    private String addressLine1;
    @Column(name="address_line2", length=200, nullable=true)
    private String addressLine2;
    @Column(name="city", length=200, nullable=true)
    private String city;
    @Column(name="state", length=200, nullable=true)
    private String state;
    @Column(name="country", length=200, nullable=true)
    private String country;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

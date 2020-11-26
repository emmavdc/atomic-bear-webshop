package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Customer")
public class CustomerEntity {

    @Id
    @Column(name="customerID")
    private Integer customerID;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="nbFidelityPoints")
    private Integer nbFidelityPoints;

    @Column(name="streetName")
    private String streetName;

    @Column(name="streetNumber")
    private String streetNumber;

    @Column(name="locality")
    private String locality;

    @Column(name="zipCode")
    private Integer zipCode;

    @Column(name="country")
    private String country;

    /* ------ GETTERS ------ */

    public Integer getCustomerID() {
        return customerID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Integer getNbFidelityPoints() {
        return nbFidelityPoints;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getLocality() {
        return locality;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    /* ------ SETTERS ------ */

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setNbFidelityPoints(Integer nbFidelityPoints) {
        this.nbFidelityPoints = nbFidelityPoints;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

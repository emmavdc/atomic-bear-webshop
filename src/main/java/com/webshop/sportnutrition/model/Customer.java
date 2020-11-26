package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import java.util.Date;

public class Customer {

    @NotNull
    private Integer customerID;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String phoneNumber;

    @NotNull
    private Date birthDate;

    @NotNull
    private Integer nbFidelityPoints;

    @NotNull
    private String streetName;

    @NotNull
    private String streetNumber;

    @NotNull
    private String locality;

    @NotNull
    private Integer zipCode;

    @NotNull
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

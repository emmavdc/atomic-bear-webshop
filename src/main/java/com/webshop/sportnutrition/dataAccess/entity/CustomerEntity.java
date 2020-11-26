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
}

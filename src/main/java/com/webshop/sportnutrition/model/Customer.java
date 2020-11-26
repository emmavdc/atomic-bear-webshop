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
}

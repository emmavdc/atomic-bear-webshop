package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public class Customer implements UserDetails {

    @NotNull
    @Min(value = 1)
    private Integer customerID;

    /*@NotNull
    private String email;*/

    @NotNull
    @Size(min = 5, max = 45)
    private String username;

    @NotNull
    @Size(min = 8, max = 60)
    private String password;

    @NotNull
    private String authorities;

    @NotNull
    @Size(min = 3, max = 45)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 45)
    private String lastName;

    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotNull
    private Date birthDate;

    @NotNull
    @Min(value = 0)
    private Integer nbFidelityPoints;

    @NotNull
    @Size(min = 3, max = 45)
    private String streetName;

    @NotNull
    @Size(min = 1, max = 10)
    private String streetNumber;

    @NotNull
    @Size(min = 3, max = 45)
    private String locality;

    @NotNull
    @Min(value = 1000)
    @Max(value = 99999)
    private Integer zipCode;

    @NotNull
    @Size(min = 3, max = 45)
    private String country;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    /* ------ CONSTRUCT ------ */

    public Customer(Integer customerID, String username, String password, String authorities, String firstName, String lastName, String phoneNumber, Date birthDate, Integer nbFidelityPoints, String streetName, String streetNumber, String locality, Integer zipCode, String country, Boolean accountNonExpired, Boolean accountNonLocked, Boolean credentialsNonExpired, Boolean enabled) {
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.nbFidelityPoints = nbFidelityPoints;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.locality = locality;
        this.zipCode = zipCode;
        this.country = country;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    public Customer() {

    }

    /* ------ GETTERS ------ */

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (!isEmpty(authorities)) {
            String[] authoritiesAsArray = authorities.split(",");

            for (String authority : authoritiesAsArray) {
                if (!isEmpty(authority)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }

        return grantedAuthorities;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    /*public String getEmail() {
        return email;
    }*/

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
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

    /*public void setEmail(String email) {
        this.email = email;
    }*/

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
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

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

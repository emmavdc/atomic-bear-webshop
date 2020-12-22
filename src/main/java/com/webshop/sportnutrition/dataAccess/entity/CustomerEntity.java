package com.webshop.sportnutrition.dataAccess.entity;

import com.sun.istack.NotNull;

//import org.hibernate.id.enhanced.TableGenerator;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="customer_id", unique=true, nullable = false)
    private Integer customerID;

    /*@Column(name="email")
    private String email;*/

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name="authorities")
    private String authorities;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;

    /*@Column(name="birth_date")
    private Date birthDate;

    @Transient
    private String strBirthDate;*/

    @Column(name="nb_fidelity_points")
    private Integer nbFidelityPoints;

    @Column(name="street_name")
    private String streetName;

    @Column(name="street_number")
    private String streetNumber;

    @Column(name="locality")
    private String locality;

    @Column(name="zip_code")
    private Integer zipCode;

    @Column(name="country")
    private String country;

    @Column(name="account_non_expired")
    private Boolean accountNonExpired;

    @Column(name="account_non_locked")
    private Boolean accountNonLocked;

    @Column(name="credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name="enabled")
    private Boolean enabled;

    /* ------ GETTERS ------ */

    public Integer getCustomerID() {
        return customerID;
    }

    /*public String getEmail() {
        return email;
    }*/

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getAuthorities() {
        return authorities;
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

    /*public Date getBirthDate() {
        return birthDate;
    }

    public String getStrBirthDate() {
        return strBirthDate;
    }*/

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

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
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

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    /*public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setStrBirthDate(String strBirthDate) {
        this.strBirthDate = strBirthDate;
    }*/

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

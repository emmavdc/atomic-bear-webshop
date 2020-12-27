package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class Order {

    @NotNull
    @Min(value = 1)
    private Integer orderID;

    @NotNull
    private Date date;

    @NotNull
    private Boolean isPaid;

    @Min(value = 1)
    private Integer reduction;

    @NotNull
    private String customerFK;

    /* ------ GETTERS ------ */

    public Integer getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public Integer getReduction() {
        return reduction;
    }

    public String getCustomerFK() {
        return customerFK;
    }

    /* ------ SETTERS ------ */

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public void setReduction(Integer reduction) {
        this.reduction = reduction;
    }

    public void setCustomerFK(String customerFK) {
        this.customerFK = customerFK;
    }
}

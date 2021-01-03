package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    @NotNull
    @Min(value = 1)
    private Integer orderID;

    @NotNull
    private Date orderDate;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private Boolean isPaid;

    @Min(value = 1)
    private Integer reduction;

    @NotNull
    private Customer customer;

    private ArrayList<OrderLine> orderLines;

    /* ------ GETTERS ------ */

    public Integer getOrderID() {
        return orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public Integer getReduction() {
        return reduction;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<OrderLine> getOrderLines() { return orderLines; }

    /* ------ SETTERS ------ */

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public void setReduction(Integer reduction) {
        this.reduction = reduction;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}

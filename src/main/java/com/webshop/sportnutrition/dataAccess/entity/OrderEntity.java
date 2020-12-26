package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="order")
public class OrderEntity {

    @Id
    @Column(name="order_id")
    private Integer orderID;

    @Column(name="date")
    private Date date;

    @Column(name="is_paid")
    private Boolean isPaid;

    @Column(name="reduction")
    private Integer reduction;

    @JoinColumn(name="customer_fk", referencedColumnName = "customer_id")
    @ManyToOne
    private CustomerEntity customer;

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

    public CustomerEntity getCustomer() {
        return customer;
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

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }
}

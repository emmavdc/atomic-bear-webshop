package com.webshop.sportnutrition.dataAccess.entity;

import com.webshop.sportnutrition.model.OrderLine;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="`order`")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Integer orderID;

    @Column(name="order_date")
    private Date orderDate;

    @Column(name="delivery_date")
    private Date deliveryDate;

    @Column(name="is_paid")
    private Boolean isPaid;

    @Column(name="reduction")
    private Integer reduction;

    @JoinColumn(name="customer_fk", referencedColumnName = "customer_id")
    @ManyToOne
    private CustomerEntity customer;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="order_fk")
    private List<OrderLineEntity> orderLines = new ArrayList<>();


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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public List<OrderLineEntity> getOrderLines() {
        return orderLines;
    }


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

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public void setOrderLines(ArrayList<OrderLineEntity> orderLines) {
        this.orderLines = orderLines;
    }
}

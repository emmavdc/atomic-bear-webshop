package com.webshop.sportnutrition.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Order")
public class Order {

    @Id
    @Column(name="orderID")
    private Integer orderID;

    @Column(name="date")
    private Date date;

    @Column(name="isPaid")
    private Boolean isPaid;

    @Column(name="reduction")
    private Integer reduction;

    @Column(name="customerFK")
    private String customerFK;
}

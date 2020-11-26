package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Order")
public class OrderEntity {

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

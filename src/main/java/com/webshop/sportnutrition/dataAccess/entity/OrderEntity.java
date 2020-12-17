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
}

package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="OrderLine")
public class OrderLineEntity {

    @Id
    @Column(name="orderLineID")
    private Integer orderLineID;

    @Column(name="price")
    private Double price;

    @Column(name="deliveryDate")
    private Date deliveryDate;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="orderFK")
    private Integer orderFK;

    @Column(name="itemFK")
    private Integer itemFK;
}

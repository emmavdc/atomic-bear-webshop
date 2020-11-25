package com.webshop.sportnutrition.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="OrderLine")
public class OrderLine {

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

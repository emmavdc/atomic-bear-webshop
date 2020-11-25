package com.webshop.sportnutrition.model;

import javax.persistence.*;

@Entity
@Table(name="Discount")
public class Discount {

    @Id
    @Column(name="discountID")
    private Integer discountID;

    @Column(name="discount")
    private Integer discount;

    @Column(name="label")
    private String label;
}

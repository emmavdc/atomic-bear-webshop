package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="discount")
public class DiscountEntity {

    @Id
    @Column(name="discount_id")
    private Integer discountID;

    @Column(name="discount")
    private Integer discount;

    @Column(name="label")
    private String label;
}

package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Discount")
public class DiscountEntity {

    @Id
    @Column(name="discountID")
    private Integer discountID;

    @Column(name="discount")
    private Integer discount;

    @Column(name="label")
    private String label;
}

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

    /* ------ GETTERS ------ */

    public Integer getDiscountID() {
        return discountID;
    }

    public Integer getDiscount() {
        return discount;
    }

    public String getLabel() {
        return label;
    }

    /* ------ SETTERS ------ */

    public void setDiscountID(Integer discountID) {
        this.discountID = discountID;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

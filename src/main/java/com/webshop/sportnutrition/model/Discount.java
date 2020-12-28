package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Discount {

    @NotNull
    @Min(value = 1)
    private Integer discountID;

    @NotNull
    @Min(value = 1)
    private Integer discount;

    @NotNull
    @Size(min = 3, max = 45)
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

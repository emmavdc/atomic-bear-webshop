package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import java.util.Date;

public class OrderLine {

    @NotNull
    @Min(value = 1)
    private Integer orderLineID;

    @NotNull
    @Min(value = 1)
    private Double price;

    @NotNull
    private Date deliveryDate;

    @NotNull
    @Min(value = 1)
    //@Max(value = item.currentInventory)
    private Integer quantity;

    @NotNull
    private Integer orderFK;

    @NotNull
    private Integer itemFK;

    /* ------ GETTERS ------ */

    public Integer getOrderLineID() {
        return orderLineID;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getOrderFK() {
        return orderFK;
    }

    public Integer getItemFK() {
        return itemFK;
    }

    /* ------ SETTERS ------ */

    public void setOrderLineID(Integer orderLineID) {
        this.orderLineID = orderLineID;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrderFK(Integer orderFK) {
        this.orderFK = orderFK;
    }

    public void setItemFK(Integer itemFK) {
        this.itemFK = itemFK;
    }
}

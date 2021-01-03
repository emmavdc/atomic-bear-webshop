package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    @Min(value = 1)
    //@Max(value = item.currentInventory)
    private Integer quantity;

    @NotNull
    private Integer orderFK;

    private Integer itemID;

    @NotNull
    private Item item;

    private Order order;

    /* ------ GETTERS ------ */

    public Integer getOrderLineID() {
        return orderLineID;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getOrderFK() {
        return orderFK;
    }

    public Integer getItemID() {
        return itemID;
    }

    public Item getItem() {
        return item;
    }

    /* ------ SETTERS ------ */

    public void setOrderLineID(Integer orderLineID) {
        this.orderLineID = orderLineID;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrderFK(Integer orderFK) {
        this.orderFK = orderFK;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}

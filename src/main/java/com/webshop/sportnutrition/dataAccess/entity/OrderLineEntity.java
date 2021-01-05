package com.webshop.sportnutrition.dataAccess.entity;

import com.webshop.sportnutrition.model.OrderLine;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="order_line")
public class OrderLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_line_id")
    private Integer orderLineID;

    @Column(name="price")
    private double  price;

    @Column(name="quantity")
    private Integer quantity;


    @JoinColumn(name="item_fk", referencedColumnName = "item_id")
    @ManyToOne
    private ItemEntity item;

    public Integer getOrderLineID() {
        return orderLineID;
    }

    public void setOrderLineID(Integer orderLineID) {
        this.orderLineID = orderLineID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
}

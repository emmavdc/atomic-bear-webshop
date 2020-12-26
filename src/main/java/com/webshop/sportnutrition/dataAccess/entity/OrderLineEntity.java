package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="order_line")
public class OrderLineEntity {

    @Id
    @Column(name="order_line_id")
    private Integer orderLineID;

    @Column(name="price")
    private Double price;

    @Column(name="delivery_date")
    private Date deliveryDate;

    @Column(name="quantity")
    private Integer quantity;

    @JoinColumn(name="order_fk", referencedColumnName = "order_id")
    @ManyToOne
    private OrderEntity order;

    @JoinColumn(name="item_fk", referencedColumnName = "item_id")
    @OneToOne
    private ItemEntity item;

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

    public OrderEntity getOrder() {
        return order;
    }

    public ItemEntity getItem() {
        return item;
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

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }
}

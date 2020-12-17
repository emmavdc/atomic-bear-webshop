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
}

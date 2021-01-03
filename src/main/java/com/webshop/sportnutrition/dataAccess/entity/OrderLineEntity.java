package com.webshop.sportnutrition.dataAccess.entity;

import com.webshop.sportnutrition.model.OrderLine;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="`order_line`")
public class OrderLineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_line_id", unique=true, nullable = false)
    private Integer orderID;

    @Column(name="price")
    private double  price;

    @Column(name="quantity")
    private Integer quantity;


    @JoinColumn(name="item_fk", referencedColumnName = "item_id", insertable = false)
    @ManyToOne
    private ItemEntity item;

    @JoinColumn(name="order_fk", referencedColumnName = "order_id")
    @OneToOne
    private OrderEntity order;
}

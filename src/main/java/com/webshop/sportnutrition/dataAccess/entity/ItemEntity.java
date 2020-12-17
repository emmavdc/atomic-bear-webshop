package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="item")
public class ItemEntity {

    @Id
    @Column(name="item_id")
    private Integer itemID;

    @Column(name="label")
    private String label;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @Column(name="brand")
    private String brand;

    @Column(name="current_inventory")
    private Integer currentInventory;
}

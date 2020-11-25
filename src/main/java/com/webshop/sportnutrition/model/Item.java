package com.webshop.sportnutrition.model;

import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @Column(name="itemID")
    private Integer itemID;

    @Column(name="label")
    private String label;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @Column(name="brand")
    private String brand;

    @Column(name="currentInventory")
    private Integer currentInventory;
}

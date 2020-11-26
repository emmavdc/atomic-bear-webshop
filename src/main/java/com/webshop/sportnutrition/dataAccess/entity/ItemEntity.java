package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class ItemEntity {

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

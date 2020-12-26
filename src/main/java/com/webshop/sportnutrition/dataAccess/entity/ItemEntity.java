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

    /* ------ GETTERS ------ */

    public Integer getItemID() {
        return itemID;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getCurrentInventory() {
        return currentInventory;
    }

    /* ------ SETTERS ------ */

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCurrentInventory(Integer currentInventory) {
        this.currentInventory = currentInventory;
    }
}

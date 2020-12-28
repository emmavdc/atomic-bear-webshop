package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Item {

    @NotNull
    @Min(value = 1)
    private Integer itemID;

    @NotNull
    @Size(min = 3, max = 45)
    private String label;

    @NotNull
    @Size(min = 3, max = 45)
    private String description;

    @NotNull
    @Min(value = 1)
    private Double price;

    @NotNull
    @Size(min = 3, max = 45)
    private String brand;

    @NotNull
    @Min(value = 1)
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

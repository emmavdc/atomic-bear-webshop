package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

public class Item {

    @NotNull
    private Integer itemID;

    @NotNull
    private String label;

    @NotNull
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private String brand;

    @NotNull
    private Integer currentInventory;
}

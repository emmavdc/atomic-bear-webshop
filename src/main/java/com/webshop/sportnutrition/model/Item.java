package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
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
}

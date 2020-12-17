package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class OrderLine {

    @NotNull
    @Min(value = 1)
    private Integer orderLineID;

    @NotNull
    @Min(value = 1)
    private Double price;

    @NotNull
    private Date deliveryDate;

    @NotNull
    @Min(value = 1)
    //@Max(value = item.currentInventory)
    private Integer quantity;

    @NotNull
    private Integer orderFK;

    @NotNull
    private Integer itemFK;
}

package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import java.util.Date;

public class OrderLine {

    @NotNull
    private Integer orderLineID;

    @NotNull
    private Double price;

    @NotNull
    private Date deliveryDate;

    @NotNull
    private Integer quantity;

    @NotNull
    private Integer orderFK;

    @NotNull
    private Integer itemFK;
}

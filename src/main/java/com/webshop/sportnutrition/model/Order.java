package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import java.util.Date;

public class Order {

    @NotNull
    private Integer orderID;

    @NotNull
    private Date date;

    @NotNull
    private Boolean isPaid;

    @NotNull
    private Integer reduction;

    @NotNull
    private String customerFK;
}

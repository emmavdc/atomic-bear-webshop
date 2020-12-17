package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

public class Order {

    @NotNull
    @Min(value = 1)
    private Integer orderID;

    @NotNull
    private Date date;

    @NotNull
    private Boolean isPaid;

    @Min(value = 1)
    private Integer reduction;

    @NotNull
    private String customerFK;
}

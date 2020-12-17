package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Discount {

    @NotNull
    @Min(value = 1)
    private Integer discountID;

    @NotNull
    @Min(value = 1)
    private Integer discount;

    @NotNull
    @Size(min = 3, max = 45)
    private String label;
}

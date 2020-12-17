package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Category {

    @NotNull
    @Min(value = 1)
    private Integer categoryID;
}

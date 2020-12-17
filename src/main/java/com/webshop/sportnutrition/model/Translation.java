package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Translation {

    @NotNull
    @Min(value = 1)
    private Integer translationID;

    @NotNull
    @Size(min = 1, max = 45)
    private String label;

    @NotNull
    private Integer categoryFK;

    @NotNull
    private Integer languageFK;
}

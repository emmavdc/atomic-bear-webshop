package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

public class Translation {

    @NotNull
    private Integer translationID;

    @NotNull
    private String label;

    @NotNull
    private Integer categoryFK;

    @NotNull
    private Integer languageFK;
}

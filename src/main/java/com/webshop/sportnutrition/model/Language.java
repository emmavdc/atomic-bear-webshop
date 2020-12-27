package com.webshop.sportnutrition.model;

import com.sun.istack.NotNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Language {

    @NotNull
    @Min(value = 1)
    private Integer languageID;

    public Integer getLanguageID() {
        return languageID;
    }

    public void setLanguageID(Integer languageID) {
        this.languageID = languageID;
    }
}

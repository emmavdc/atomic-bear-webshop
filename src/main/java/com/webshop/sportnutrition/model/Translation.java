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

    /* ------ GETTERS ------ */

    public Integer getTranslationID() {
        return translationID;
    }

    public String getLabel() {
        return label;
    }

    public Integer getCategoryFK() {
        return categoryFK;
    }

    public Integer getLanguageFK() {
        return languageFK;
    }

    /* ------ SETTERS ------ */

    public void setTranslationID(Integer translationID) {
        this.translationID = translationID;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCategoryFK(Integer categoryFK) {
        this.categoryFK = categoryFK;
    }

    public void setLanguageFK(Integer languageFK) {
        this.languageFK = languageFK;
    }
}

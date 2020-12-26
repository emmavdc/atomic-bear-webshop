package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="translation")
public class TranslationEntity {

    @Id
    @Column(name="translation_id")
    private Integer translationID;

    @Column(name="label")
    private String label;

    @JoinColumn(name="category_fk", referencedColumnName = "category_id")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name="language_fk", referencedColumnName = "language_id")
    @ManyToOne
    private LanguageEntity language;

    /* ------ GETTERS ------ */

    public Integer getTranslationID() {
        return translationID;
    }

    public String getLabel() {
        return label;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    /* ------ SETTERS ------ */

    public void setTranslationID(Integer translationID) {
        this.translationID = translationID;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}

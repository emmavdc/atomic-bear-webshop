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
}

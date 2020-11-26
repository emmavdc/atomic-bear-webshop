package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Translation")
public class TranslationEntity {

    @Id
    @Column(name="translationID")
    private Integer translationID;

    @Column(name="label")
    private String label;

    @Column(name="categoryFK")
    private Integer categoryFK;

    @Column(name="languageFK")
    private Integer languageFK;
}

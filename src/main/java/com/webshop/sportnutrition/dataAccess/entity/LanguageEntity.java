package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Language")
public class LanguageEntity {

    @Id
    @Column(name="languageID")
    private Integer languageID;
}

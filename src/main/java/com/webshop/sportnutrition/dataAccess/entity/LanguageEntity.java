package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="language")
public class LanguageEntity {

    @Id
    @Column(name="language_id")
    private Integer languageID;
}

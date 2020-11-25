package com.webshop.sportnutrition.model;

import javax.persistence.*;

@Entity
@Table(name="Language")
public class Language {

    @Id
    @Column(name="languageID")
    private Integer languageID;
}

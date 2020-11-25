package com.webshop.sportnutrition.model;

import javax.persistence.*;

@Entity
@Table(name="Translation")
public class Translation {

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

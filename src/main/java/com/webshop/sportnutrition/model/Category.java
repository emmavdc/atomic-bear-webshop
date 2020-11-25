package com.webshop.sportnutrition.model;

import javax.persistence.*;

@Entity
@Table(name="Category")
public class Category {

    @Id
    @Column(name="categoryID")
    private Integer categoryID;
}

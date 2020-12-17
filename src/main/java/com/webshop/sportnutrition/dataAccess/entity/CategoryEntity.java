package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name="category_id")
    private Integer categoryID;
}

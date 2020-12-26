package com.webshop.sportnutrition.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoryEntity {

    @Id
    @Column(name="category_id")
    private Integer categoryID;

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }
}

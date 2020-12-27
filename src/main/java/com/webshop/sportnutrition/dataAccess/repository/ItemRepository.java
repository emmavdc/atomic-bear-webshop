package com.webshop.sportnutrition.dataAccess.repository;

import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

    List<ItemEntity> findByCategoryOrderByLabel(CategoryEntity category);
}

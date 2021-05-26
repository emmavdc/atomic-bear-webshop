package com.webshop.sportnutrition.dataAccess.repository;

import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.entity.ItemEntity;
import com.webshop.sportnutrition.dataAccess.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    /*@Query(value = "SELECT order_id FROM order ORDER BY order_id desc")
    OrderEntity findLastOrder();*/

}

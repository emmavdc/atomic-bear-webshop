package com.webshop.sportnutrition.service;

import com.webshop.sportnutrition.model.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface OrderServiceInterface {
    public ArrayList<String> SaveOrder(Order order);
}

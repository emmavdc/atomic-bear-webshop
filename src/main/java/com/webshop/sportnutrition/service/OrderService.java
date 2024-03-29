package com.webshop.sportnutrition.service;

import com.webshop.sportnutrition.dataAccess.dao.OrderDataAccess;
import com.webshop.sportnutrition.model.Customer;
import com.webshop.sportnutrition.model.Order;
import com.webshop.sportnutrition.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class OrderService implements OrderServiceInterface{

    private OrderDataAccess orderDataAccess;

    @Autowired
    public OrderService(OrderDataAccess orderDataAccess) {
        this.orderDataAccess = orderDataAccess;
    }

    @Override
    public ArrayList<String> SaveOrder(Order order) {
        ArrayList<String> returnCodes = new ArrayList<>();

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Customer customer = (Customer) authentication.getPrincipal();
            order.setCustomer(customer);
            order.setOrderDate(new Date());
            LocalDateTime localDateTime = LocalDateTime.now();
            Date date = Date.from(localDateTime.plusDays(5).atZone(ZoneId.systemDefault()).toInstant());
            order.setDeliveryDate(date);
            order.setReduction(0);
            order.setPaid(false);

            this.orderDataAccess.save(order);

            returnCodes.add("rcOrder01");
        }
        catch (Exception ex) {
            returnCodes.add("rcOrder02");
        }

        return returnCodes;
    }
}

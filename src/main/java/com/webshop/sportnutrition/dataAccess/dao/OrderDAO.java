package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.entity.OrderEntity;
import com.webshop.sportnutrition.dataAccess.repository.LanguageRepository;
import com.webshop.sportnutrition.dataAccess.repository.OrderRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderDAO implements OrderDataAccess {

    private OrderRepository orderRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public OrderDAO(OrderRepository orderRepository, ProviderConverter providerConverter) {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }


    @Override
    public void save(Order order) {

        OrderEntity oe = this.providerConverter.orderModelToOrderEntity(order);
            this.orderRepository.save(oe);
    }
}

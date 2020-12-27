package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.model.Customer;

public interface CustomerDataAccess {
    public Customer save(Customer customer);

    //public Customer findByEmail(String email);
    public Customer findByUsername(String username);
}

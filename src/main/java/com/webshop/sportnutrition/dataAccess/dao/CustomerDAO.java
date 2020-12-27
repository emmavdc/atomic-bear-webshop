package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.entity.CustomerEntity;
import com.webshop.sportnutrition.dataAccess.repository.CustomerRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerDAO implements CustomerDataAccess {
    public CustomerRepository customerRepository;
    public ProviderConverter providerConverter;

    @Autowired
    public CustomerDAO(CustomerRepository customerRepository, ProviderConverter providerConverter) {
        this.customerRepository = customerRepository;
        this.providerConverter = providerConverter;
    }

    public Customer save(Customer customer) {
        CustomerEntity customerEntity = providerConverter.customerModelToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }

    @Override
    public Customer findByUsername(String username) {
        CustomerEntity customerEntity = customerRepository.findByUsername(username);
        if (customerEntity == null)
            return null;
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }
}

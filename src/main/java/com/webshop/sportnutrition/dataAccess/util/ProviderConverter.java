package com.webshop.sportnutrition.dataAccess.util;

import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.entity.CustomerEntity;
import com.webshop.sportnutrition.model.Category;
import com.webshop.sportnutrition.model.Customer;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    /*public UserEntity userModelToUserEntity(User user) {
        return mapper.map(user, UserEntity.class);
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        return mapper.map(userEntity, User.class);
    }*/

    /* ------------ Customer ------------ */

    public CustomerEntity customerModelToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        CryptPassword cryptPassword = new CryptPassword();
        customerEntity.setPassword(cryptPassword.crypt(customer.getPassword()));
        //customerEntity.setBirthDate(new Date(customer.getBirthDate().getTime()));
        customerEntity.setBirthDate(Date.valueOf(customer.getBirthDate()));
        //customerEntity.setAuthorities(customer.getAuthorities());
        /*customerEntity.setAccountNonExpired(customer.isAccountNonExpired());
        customerEntity.setAccountNonLocked(customer.isAccountNonLocked());
        customerEntity.setCredentialsNonExpired(customer.isCredentialsNonExpired());
        customerEntity.setEnabled(customer.isEnabled());*/
        return customerEntity;
    }

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity) {
        Customer customer = mapper.map(customerEntity, Customer.class);
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        customer.setAccountNonLocked(customerEntity.getAccountNonLocked());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setEnabled(customerEntity.getEnabled());
        return customer;
    }

    /* ------------ Category ------------ */

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        return mapper.map(category, CategoryEntity.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        return mapper.map(categoryEntity, Category.class);
    }
}

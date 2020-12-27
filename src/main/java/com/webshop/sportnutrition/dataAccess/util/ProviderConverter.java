package com.webshop.sportnutrition.dataAccess.util;

import com.webshop.sportnutrition.dataAccess.entity.*;
import com.webshop.sportnutrition.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ProviderConverter {

    private Mapper mapper = new DozerBeanMapper();

    /* ------------ Customer ------------ */

    public CustomerEntity customerModelToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        CryptPassword cryptPassword = new CryptPassword();
        customerEntity.setPassword(cryptPassword.crypt(customer.getPassword()));
        //customerEntity.setBirthDate(new Date(customer.getBirthDate().getTime()));
        //customerEntity.setBirthDate(Date.valueOf(customer.getBirthDate()));
        //customerEntity.setAuthorities(customer.getAuthorities());
        /*customerEntity.setAccountNonExpired(customer.isAccountNonExpired());
        customerEntity.setAccountNonLocked(customer.isAccountNonLocked());
        customerEntity.setCredentialsNonExpired(customer.isCredentialsNonExpired());
        customerEntity.setEnabled(customer.isEnabled());*/

        //Remplissage ici car les valeurs par défaut de la BD ne s'appliquent pas
        /*customerEntity.setAccountNonExpired(true);
        customerEntity.setAccountNonLocked(true);
        customerEntity.setCredentialsNonExpired(true);
        customerEntity.setEnabled(true);
        customerEntity.setAuthorities("ROLE_USER");
        customerEntity.setNbFidelityPoints(0);*/
        //Remplissage de l'objet dans controller car les valeurs par défaut de la BD ne sont pas effective
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

    /* ------------ Language ------------ */

    public LanguageEntity languageModelToLanguageEntity(Language language) {
        return mapper.map(language, LanguageEntity.class);
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        return mapper.map(languageEntity, Language.class);
    }

    /* ------------ Translation ------------ */

    public TranslationEntity translationModelToTranslationEntity(Translation translation) {
        return mapper.map(translation, TranslationEntity.class);
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        return mapper.map(translationEntity, Translation.class);
    }

    /* ------------ Discount ------------ */

    public DiscountEntity discountModelToDiscountEntity(Discount discount) {
        return mapper.map(discount, DiscountEntity.class);
    }

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity) {
        return mapper.map(discountEntity, Discount.class);
    }

    /* ------------ Item ------------ */

    public ItemEntity itemModelToItemEntity(Item item) {
        return mapper.map(item, ItemEntity.class);
    }

    public Item itemEntityToItemModel(ItemEntity itemEntity) {
        return mapper.map(itemEntity, Item.class);
    }

    /* ------------ Order ------------ */

    public OrderEntity orderModelToOrderEntity(Order order) {
        return mapper.map(order, OrderEntity.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        return mapper.map(orderEntity, Order.class);
    }

    /* ------------ OrderLine ------------ */

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        return mapper.map(orderLine, OrderLineEntity.class);
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
        return mapper.map(orderLineEntity, OrderLine.class);
    }
}

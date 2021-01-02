package com.webshop.sportnutrition.dataAccess.util;

import com.webshop.sportnutrition.dataAccess.entity.*;
import com.webshop.sportnutrition.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private Mapper mapper;

    /* ------------ Customer ------------ */

    public CustomerEntity customerModelToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = getMapper().map(customer, CustomerEntity.class);
        CryptPassword cryptPassword = new CryptPassword();
        customerEntity.setPassword(cryptPassword.crypt(customer.getPassword()));
        return customerEntity;
    }

    public Customer customerEntityToCustomerModel(CustomerEntity customerEntity) {
        Customer customer = getMapper().map(customerEntity, Customer.class);
        customer.setAuthorities(customerEntity.getAuthorities());
        customer.setAccountNonExpired(customerEntity.getAccountNonExpired());
        customer.setAccountNonLocked(customerEntity.getAccountNonLocked());
        customer.setCredentialsNonExpired(customerEntity.getCredentialsNonExpired());
        customer.setEnabled(customerEntity.getEnabled());
        return customer;
    }

    /* ------------ Category ------------ */

    public CategoryEntity categoryModelToCategoryEntity(Category category) {
        return getMapper().map(category, CategoryEntity.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity) {
        return getMapper().map(categoryEntity, Category.class);
    }

    /* ------------ Language ------------ */

    public LanguageEntity languageModelToLanguageEntity(Language language) {
        return getMapper().map(language, LanguageEntity.class);
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        return getMapper().map(languageEntity, Language.class);
    }

    /* ------------ Translation ------------ */

    public TranslationEntity translationModelToTranslationEntity(Translation translation) {
        return getMapper().map(translation, TranslationEntity.class);
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        return getMapper().map(translationEntity, Translation.class);
    }

    /* ------------ Discount ------------ */

    public DiscountEntity discountModelToDiscountEntity(Discount discount) {
        return getMapper().map(discount, DiscountEntity.class);
    }

    public Discount discountEntityToDiscountModel(DiscountEntity discountEntity) {
        return getMapper().map(discountEntity, Discount.class);
    }

    /* ------------ Item ------------ */

    public ItemEntity itemModelToItemEntity(Item item) {
        return getMapper().map(item, ItemEntity.class);
    }

    public Item itemEntityToItemModel(ItemEntity itemEntity) {
        return getMapper().map(itemEntity, Item.class);
    }

    /* ------------ Order ------------ */

    public OrderEntity orderModelToOrderEntity(Order order) {
        return getMapper().map(order, OrderEntity.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity) {
        return getMapper().map(orderEntity, Order.class);
    }

    /* ------------ OrderLine ------------ */

    public OrderLineEntity orderLineModelToOrderLineEntity(OrderLine orderLine) {
        return getMapper().map(orderLine, OrderLineEntity.class);
    }

    public OrderLine orderLineEntityToOrderLineModel(OrderLineEntity orderLineEntity) {
        return getMapper().map(orderLineEntity, OrderLine.class);
    }

    private Mapper getMapper() {
        if (mapper == null ) mapper = new DozerBeanMapper();
        return mapper;
    }
}

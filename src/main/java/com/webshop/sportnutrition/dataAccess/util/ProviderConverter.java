package com.webshop.sportnutrition.dataAccess.util;

import com.webshop.sportnutrition.dataAccess.entity.*;
import com.webshop.sportnutrition.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderConverter {

    private final Mapper mapper = new DozerBeanMapper();

    /* ------------ Customer ------------ */

    public CustomerEntity customerModelToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = mapper.map(customer, CustomerEntity.class);
        CryptPassword cryptPassword = new CryptPassword();
        customerEntity.setPassword(cryptPassword.crypt(customer.getPassword()));
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

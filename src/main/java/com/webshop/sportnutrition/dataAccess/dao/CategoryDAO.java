package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.repository.CategoryRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess {

    public CategoryRepository categoryRepository;
    public ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO(CategoryRepository categoryRepository, ProviderConverter providerConverter) {
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    /*public Category save(Category category) {
        CategoryEntity categoryEntity = providerConverter.customerModelToCustomerEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return providerConverter.customerEntityToCustomerModel(customerEntity);
    }*/

    @Override
    public ArrayList<Category> getAll() {
        //return providerConverter.categoryEntityToCategoryModel(categoryRepository.findAll());
        return convertListFromDBToArrayList(categoryRepository.findAll());
    }

    public ArrayList<Category> convertListFromDBToArrayList(List<CategoryEntity> listFromDB) {
        ArrayList<Category> categories = new ArrayList<>();
        for (CategoryEntity entity : listFromDB) {
            Category category = providerConverter.categoryEntityToCategoryModel(entity);
            categories.add(category);
        }
        return categories;
    }
}

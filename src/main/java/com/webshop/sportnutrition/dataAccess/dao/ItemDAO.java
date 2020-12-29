package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.dataAccess.entity.CategoryEntity;
import com.webshop.sportnutrition.dataAccess.entity.ItemEntity;
import com.webshop.sportnutrition.dataAccess.repository.CategoryRepository;
import com.webshop.sportnutrition.dataAccess.repository.ItemRepository;
import com.webshop.sportnutrition.dataAccess.util.ProviderConverter;
import com.webshop.sportnutrition.model.Category;
import com.webshop.sportnutrition.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemDAO implements ItemDataAccess {

    public ItemRepository itemRepository;
    public ProviderConverter providerConverter;

    @Autowired
    public ItemDAO(ItemRepository itemRepository, ProviderConverter providerConverter) {
        this.itemRepository = itemRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Item> getByCategory(Integer categoryID) {

        CategoryEntity categ = new CategoryEntity();
        categ.setCategoryID(categoryID);
        return convertListFromDBToArrayList(itemRepository.findByCategory(categ));
    }

    @Override
    public Item getByItemID(Integer itemID) {
        return providerConverter.itemEntityToItemModel(itemRepository.findByItemID(itemID));
    }

    public ArrayList<Item> convertListFromDBToArrayList(List<ItemEntity> listFromDB) {
        ArrayList<Item> items = new ArrayList<>();
        for (ItemEntity entity : listFromDB) {
            Item item = providerConverter.itemEntityToItemModel(entity);
            items.add(item);
        }
        return items;
    }
}

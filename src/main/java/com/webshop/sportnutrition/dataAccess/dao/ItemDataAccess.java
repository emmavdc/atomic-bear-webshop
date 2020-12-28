package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.model.Item;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;

import java.util.ArrayList;

public interface ItemDataAccess {

    ArrayList<Item> getByCategory(Integer categoryID);
    Item getByItemID(Integer itemID);

}

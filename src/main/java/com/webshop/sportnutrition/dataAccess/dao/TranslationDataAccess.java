package com.webshop.sportnutrition.dataAccess.dao;

import com.webshop.sportnutrition.model.Category;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;

import java.util.ArrayList;

public interface TranslationDataAccess {

    public ArrayList<Translation> getAll();

    public Translation getByCategoryAndLanguage(Category category, Language language);
}

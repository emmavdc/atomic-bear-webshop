package com.webshop.sportnutrition.controller;
import com.webshop.sportnutrition.dataAccess.dao.TranslationDataAccess;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Locale;

@SessionAttributes({MasterController.FRCATS, MasterController.ENCATS})
public class MasterController {

    protected static final String FRCATS="frCategories";
    protected static final String ENCATS="enCategories";


    @Autowired
    private TranslationDataAccess translationDAO;

    public MasterController(){}

    @ModelAttribute(FRCATS)
    public ArrayList<Translation> addFrenchCategoriesIntoSessionScope() {

        Language lang = new Language();
        lang.setLanguageID(1);

        return translationDAO.getCategoryByLanguage(lang);
    }

    @ModelAttribute(ENCATS)
    public ArrayList<Translation> addEnglishCategoriesIntoSessionScope() {

        Language lang = new Language();
        lang.setLanguageID(2);

        return translationDAO.getCategoryByLanguage(lang);
    }

    @ModelAttribute
    public void everyRequest(Model model,
                             @ModelAttribute(value=FRCATS) ArrayList<Translation> frTranslations,
                             @ModelAttribute(value=ENCATS) ArrayList<Translation> enTranslations) {

        Locale english = Locale.ENGLISH;
        Locale currentLang = LocaleContextHolder.getLocale();

        ArrayList<Translation> translations;

        Language lang = new Language();
        if (currentLang == english) {
                translations = enTranslations;
            }
        else {
                translations = frTranslations;
        }

        for (Translation translation : translations) {
            switch (translation.getCategory().getCategoryID()) {

                case 1:
                    model.addAttribute("proteins", translation.getLabel());
                    break;
                case 2:
                    model.addAttribute("muscleDev", translation.getLabel());
                    break;
                case 3:
                    model.addAttribute("energy", translation.getLabel());
                    break;
                case 4:
                    model.addAttribute("fatBurners", translation.getLabel());
                    break;
                case 5:
                    model.addAttribute("vitamins", translation.getLabel());
                    break;
                case 6:
                    model.addAttribute("snackAndDrinks", translation.getLabel());
                    break;
                case 7:
                    model.addAttribute("accessories", translation.getLabel());
                    break;
            }
        }
    }
}
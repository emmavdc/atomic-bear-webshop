package com.webshop.sportnutrition.controller;
import com.webshop.sportnutrition.dataAccess.dao.TranslationDataAccess;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.ArrayList;
import java.util.Locale;

public class MasterController {

    @Autowired
    private TranslationDataAccess translationDAO;

    public MasterController(){}

    @ModelAttribute
    public void everyRequest(Model model) {

        /*Locale french = Locale.FRENCH;
        Locale currentLang = LocaleContextHolder.getLocale();

        Language lang = new Language();
        if (currentLang == french)
            lang.setLanguageID(1);
        else
            lang.setLanguageID(2);*/

        Locale english = Locale.ENGLISH;
        Locale currentLang = LocaleContextHolder.getLocale();

        Language lang = new Language();
        if (currentLang == english)
            lang.setLanguageID(2);
        else
            lang.setLanguageID(1);

        ArrayList<Translation> translations = translationDAO.getCategoryByLanguage(lang);

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
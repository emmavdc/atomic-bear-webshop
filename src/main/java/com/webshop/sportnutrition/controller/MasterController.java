package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.*;
import com.webshop.sportnutrition.model.Category;
import com.webshop.sportnutrition.model.Customer;
import com.webshop.sportnutrition.model.Language;
import com.webshop.sportnutrition.model.Translation;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Controller
//@RequestMapping(value="/masterController")
public class MasterController {

    /*@RequestMapping(method = RequestMethod.GET)
    public String authenticated(Authentication authentication) {
        Customer userDetails = (Customer) authentication.getPrincipal();
        return userDetails;
    }*/

    private LanguageDataAccess languageDAO;
    private CategoryDataAccess categoryDAO;
    private TranslationDataAccess translationDAO;

    @Autowired
    public MasterController(LanguageDataAccess languageDAO, CategoryDataAccess categoryDAO, TranslationDataAccess translationDAO) {
        this.languageDAO = languageDAO;
        this.categoryDAO = categoryDAO;
        this.translationDAO = translationDAO;
    }

    //@RequestMapping(method = RequestMethod.GET)
    public void categories(Model model){

        Locale french = Locale.FRENCH;
        //Locale french_be = new Locale("fr", "BE");
        //Locale english = Locale.ENGLISH;
        Locale currentLang = LocaleContextHolder.getLocale();

        ArrayList<Language> languages = languageDAO.getAll();
        ArrayList<Category> categories = categoryDAO.getAll();

        Language lang;
        if (currentLang == french)
            lang = languages.get(0);
        else
            lang = languages.get(1);

        model.addAttribute("proteins", translationDAO.getByCategoryAndLanguage(categories.get(0), lang).getLabel());
        model.addAttribute("muscleDev", translationDAO.getByCategoryAndLanguage(categories.get(1), lang).getLabel());
        model.addAttribute("energy", translationDAO.getByCategoryAndLanguage(categories.get(2), lang).getLabel());
        model.addAttribute("fatBurners", translationDAO.getByCategoryAndLanguage(categories.get(3), lang).getLabel());
        model.addAttribute("vitamins", translationDAO.getByCategoryAndLanguage(categories.get(4), lang).getLabel());
        model.addAttribute("snackAndDrinks", translationDAO.getByCategoryAndLanguage(categories.get(5), lang).getLabel());
        model.addAttribute("accessories", translationDAO.getByCategoryAndLanguage(categories.get(6), lang).getLabel());
    }
}

/*if(LocaleContextHolder.getLocale() == french)
    System.out.println("C'est en FR");
else {
    if(LocaleContextHolder.getLocale() == fr)
        System.out.println("C'est en FR_BE");
    else {
        if(LocaleContextHolder.getLocale() == english)
            System.out.println("C'est en EN");
        else
            System.out.println("C'est en undetected");
    }
}*/
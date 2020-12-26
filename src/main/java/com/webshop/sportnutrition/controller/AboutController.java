package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.CategoryDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.CustomerDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.LanguageDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.TranslationDataAccess;
import com.webshop.sportnutrition.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/aboutUs")
public class AboutController extends MasterController {

    //Extends
    private LanguageDataAccess languageDAO;
    private CategoryDataAccess categoryDAO;
    private TranslationDataAccess translationDAO;

    @Autowired
    public AboutController(LanguageDataAccess languageDAO, CategoryDataAccess categoryDAO, TranslationDataAccess translationDAO) {
        super(languageDAO, categoryDAO, translationDAO); //Extends
    }

    @RequestMapping(method = RequestMethod.GET)
    public String about(Model model){
        super.categories(model);
        model.addAttribute("title", "A propos de nous");
        return "integrated:about";
    }
}

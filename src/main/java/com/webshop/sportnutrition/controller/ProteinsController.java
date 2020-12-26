package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.CategoryDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.LanguageDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.TranslationDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/shop/proteins")
public class ProteinsController extends MasterController {

    //Extends
    private LanguageDataAccess languageDAO;
    private CategoryDataAccess categoryDAO;
    private TranslationDataAccess translationDAO;

    @Autowired
    public ProteinsController(LanguageDataAccess languageDAO, CategoryDataAccess categoryDAO, TranslationDataAccess translationDAO) {
        super(languageDAO, categoryDAO, translationDAO); //Extends
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        super.categories(model);
        model.addAttribute("title", "Protéines");
        return "integrated:proteinsItems";
    }
}

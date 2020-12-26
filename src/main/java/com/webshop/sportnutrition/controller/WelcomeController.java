package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.*;
import com.webshop.sportnutrition.model.Category;
import com.webshop.sportnutrition.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/home")
public class WelcomeController extends MasterController {

    private CustomerDataAccess customerDAO;
    //Extends
    private LanguageDataAccess languageDAO;
    private CategoryDataAccess categoryDAO;
    private TranslationDataAccess translationDAO;

    @Autowired
    public WelcomeController(CustomerDataAccess customerDAO, LanguageDataAccess languageDAO, CategoryDataAccess categoryDAO, TranslationDataAccess translationDAO) {
        super(languageDAO, categoryDAO, translationDAO); //Extends
        this.customerDAO = customerDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        super.categories(model);
        //System.out.println(categoryDAO.getAll().get(1).getCategoryID());
        model.addAttribute("title", "Sport nutrition");
        /*ArrayList<Category> categories = categoryDAO.getAll();
        model.addAttribute("categories", categoryDAO.getAll());*/
        //model.addAttribute("user", customerDAO.findByUsername("dylan.sohet@gmail.com"));
        return "integrated:welcome";
    }
}

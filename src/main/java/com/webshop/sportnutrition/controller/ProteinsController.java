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


    @Autowired
    public ProteinsController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "Protéines");
        return "integrated:proteinsItems";
    }
}

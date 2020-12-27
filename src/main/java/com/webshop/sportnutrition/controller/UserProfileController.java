package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.CategoryDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.LanguageDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.TranslationDataAccess;
import com.webshop.sportnutrition.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/myAccount")
public class UserProfileController extends MasterController {


    public UserProfileController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String account(Model model){
        model.addAttribute("title", "Mon compte");
        return "integrated:userProfile";
    }
}

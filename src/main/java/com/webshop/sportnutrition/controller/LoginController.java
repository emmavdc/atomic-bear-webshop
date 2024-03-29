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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/login")
public class LoginController extends MasterController {

    @Autowired
    public LoginController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model, @RequestParam(required = false) String error){
        if (error != null) {
            model.addAttribute("badCredential", "badCredential");
        }
        model.addAttribute("title", "login");
        model.addAttribute("user", new Customer());
        return "integrated:login";
    }
}

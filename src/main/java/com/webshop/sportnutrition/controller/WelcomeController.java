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
@RequestMapping(value="/")
public class WelcomeController extends MasterController {

    private CustomerDataAccess customerDAO;

    @Autowired
    public WelcomeController(CustomerDataAccess customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Sport nutrition");
        return "integrated:welcome";
    }
}

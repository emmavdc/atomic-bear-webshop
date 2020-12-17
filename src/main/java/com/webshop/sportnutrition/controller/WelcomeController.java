package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.CategoryDAO;
import com.webshop.sportnutrition.dataAccess.dao.CategoryDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.CustomerDataAccess;
import com.webshop.sportnutrition.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/home")
public class WelcomeController {

    private CategoryDataAccess categoryDAO;
    private CustomerDataAccess customerDAO;

    @Autowired
    public WelcomeController(CategoryDataAccess categoryDAO, CustomerDataAccess customerDAO) {
        this.categoryDAO = categoryDAO;
        this.customerDAO = customerDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Sport nutrition");
        /*ArrayList<Category> categories = categoryDAO.getAll();
        model.addAttribute("categories", categoryDAO.getAll());*/
        //model.addAttribute("user", customerDAO.findByUsername("dylan.sohet@gmail.com"));
        return "integrated:welcome";
    }
}

package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.ItemDataAccess;
import com.webshop.sportnutrition.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping(value="/shop")
public class ShopController extends MasterController {

    private final ItemDataAccess itemDAO;

    @Autowired
    public ShopController(ItemDataAccess itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(value="/proteins", method = RequestMethod.GET)
    public String protein(Model model){
        model.addAttribute("title", "Protéines");

        ArrayList<Item> items = this.itemDAO.findByCategoryOrderByLabel(1);


        return "integrated:proteinsItems";
    }

    @RequestMapping(value="/muscledev", method = RequestMethod.GET)
    public String muscleDev(Model model){
        model.addAttribute("title", "Dev musculaire");

        ArrayList<Item> items = this.itemDAO.findByCategoryOrderByLabel(2);


        return "integrated:muscledevItems";
    }
}

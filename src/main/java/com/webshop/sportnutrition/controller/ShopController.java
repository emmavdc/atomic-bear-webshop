package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.ItemDataAccess;
import com.webshop.sportnutrition.model.Item;
import com.webshop.sportnutrition.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/shop")
public class ShopController extends MasterController {

    private final ItemDataAccess itemDAO;
    private String urlCateg;

    @Autowired
    public ShopController(ItemDataAccess itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(value="/proteins", method = RequestMethod.GET)
    public String protein(Model model){
        model.addAttribute("title", "Protéines");

        ArrayList<Item> items = this.itemDAO.getByCategory(1);
        urlCateg = "proteins";
        model.addAttribute("urlCateg", urlCateg);
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:proteinsItems";
    }

    @RequestMapping(value="/muscledev", method = RequestMethod.GET)
    public String muscleDev(Model model){
        model.addAttribute("title", "Developpement musculaire");

        ArrayList<Item> items = this.itemDAO.getByCategory(2);


        return "integrated:muscledevItems";
    }

    @RequestMapping(value= "/" /*On doit rester sur la même poge d'items mais il faut récupérer le bon URL*/, method = RequestMethod.POST)
    public void addItemToCart(Model model/*,
                              @Valid @ModelAttribute(value= Constants.CURRENT_USER) Customer customer*/ /*Ici on veut la order line récupérée*/) {
        System.out.println("Test");
        /*La page ne doit pas bouger, on doit seulement récupérer les infos de Order Line pour les insérer dans le panier*/
    }
}

package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.ItemDataAccess;
import com.webshop.sportnutrition.model.Item;
import com.webshop.sportnutrition.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/shop")
@SessionAttributes({ShopController.BASKET})
public class ShopController extends MasterController {

    protected static final String BASKET="basket";
    private final ItemDataAccess itemDAO;
    private String currentURL;
    private Integer idCateg;

    @Autowired
    public ShopController(ItemDataAccess itemDAO) {
        this.itemDAO = itemDAO;
    }

    @ModelAttribute(BASKET)
    public ArrayList<OrderLine> addBasketIntoSessionScope() {
        return new ArrayList<OrderLine>();
    }




    @RequestMapping(value="/proteins", method = RequestMethod.GET)
    public String protein(Model model){
        model.addAttribute("title", "Protéines");

        idCateg = 1;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "proteins";
        //model.addAttribute("urlCateg", "proteins");
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/muscledev", method = RequestMethod.GET)
    public String muscleDev(Model model){
        model.addAttribute("title", "Developpement musculaire");

        idCateg = 2;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "muscledev";
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/energy", method = RequestMethod.GET)
    public String energy(Model model){
        model.addAttribute("title", "Energie");

        idCateg = 3;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "energy";
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/fatBurners", method = RequestMethod.GET)
    public String fatBurners(Model model){
        model.addAttribute("title", "Brûleurs de graisses");

        idCateg = 4;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "fatBurners";
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/vitamins", method = RequestMethod.GET)
    public String vitamins(Model model){
        model.addAttribute("title", "Vitamines");

        idCateg = 5;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "vitamins";
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/snackAndDrinks", method = RequestMethod.GET)
    public String snackAndDrinks(Model model){
        model.addAttribute("title", "Snacks et boissons");

        idCateg = 6;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "snackAndDrinks";
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/accessories", method = RequestMethod.GET)
    public String accessories(Model model){
        model.addAttribute("title", "Accessoires");

        idCateg = 7;
        ArrayList<Item> items = this.itemDAO.getByCategory(idCateg);
        model.addAttribute("categ", idCateg);
        currentURL = "accessories";
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addItemToCart(Model model,
                              /*@Valid @ModelAttribute(value= Constants.CURRENT_USER) Customer customer*/ /*Ici on veut la order line récupérée*/
                              @Valid @ModelAttribute OrderLine orderLine, @ModelAttribute(value = BASKET) ArrayList<OrderLine> basket ) {

        basket.add(orderLine);
        System.out.println("il y a " + basket.size() + " éléments");
        System.out.println("Page : " + currentURL + " --- Item ID : " + orderLine.getItemFK() +  " -- orderLineQuantity : " + orderLine.getQuantity());

        return "redirect:/shop/" + currentURL;

        /*Pour l'instant, il renvoit la page courrante mais la page ne doit pas bouger, on doit seulement récupérer les infos de Order Line pour les insérer dans le panier*/
    }
}

package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.ItemDataAccess;
import com.webshop.sportnutrition.model.Item;
import com.webshop.sportnutrition.model.Order;
import com.webshop.sportnutrition.model.OrderLine;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping(value="/shop")
@SessionAttributes({ShopController.CART})
public class ShopController extends MasterController {

    protected static final String CART = "cart";
    private final ItemDataAccess itemDAO;
    private String currentURL;

    @Autowired
    public ShopController(ItemDataAccess itemDAO) {
        this.itemDAO = itemDAO;
    }

    @ModelAttribute(CART)
    public ArrayList<OrderLine> addCartIntoSessionScope() {
        return new ArrayList<OrderLine>();
    }

    @RequestMapping(value="/proteins", method = RequestMethod.GET)
    public String protein(Model model){
        model.addAttribute("title", "Protéines");

        ArrayList<Item> items = this.itemDAO.getByCategory(1);
        currentURL = "proteins";
        //model.addAttribute("urlCateg", "proteins");
        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/muscledev", method = RequestMethod.GET)
    public String muscleDev(Model model){
        model.addAttribute("title", "Developpement musculaire");

        ArrayList<Item> items = this.itemDAO.getByCategory(2);
        currentURL = "muscledev";

        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/energy", method = RequestMethod.GET)
    public String energy(Model model){
        model.addAttribute("title", "Energie");

        ArrayList<Item> items = this.itemDAO.getByCategory(3);
        currentURL = "energy";

        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/fatBurners", method = RequestMethod.GET)
    public String fatBurners(Model model){
        model.addAttribute("title", "Brûleurs de graisses");

        ArrayList<Item> items = this.itemDAO.getByCategory(4);
        currentURL = "fatBurners";

        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/vitamins", method = RequestMethod.GET)
    public String vitamins(Model model){
        model.addAttribute("title", "Vitamines");

        ArrayList<Item> items = this.itemDAO.getByCategory(5);
        currentURL = "vitamins";

        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/snackAndDrinks", method = RequestMethod.GET)
    public String snackAndDrinks(Model model){
        model.addAttribute("title", "Snacks et boissons");

        ArrayList<Item> items = this.itemDAO.getByCategory(6);
        currentURL = "snackAndDrinks";

        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/accessories", method = RequestMethod.GET)
    public String accessories(Model model){
        model.addAttribute("title", "Accessoires");

        ArrayList<Item> items = this.itemDAO.getByCategory(7);
        currentURL = "accessories";

        model.addAttribute("items", items);
        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addItemToCart(Model model,
                              @Valid @ModelAttribute OrderLine orderLine,
                              @ModelAttribute(value = CART) ArrayList<OrderLine> cart) {

        //Item reference
        Item currentItem = itemDAO.getByItemID(orderLine.getItemID());

        //CurrentInventory
        Integer itemCurrentInventory = currentItem.getCurrentInventory();

        //Product already in the cart
        OrderLine foundProduct = null;
        int iProduct = 0;
        while (iProduct < cart.size() && foundProduct == null) {
            OrderLine product = cart.get(iProduct);
            if (product.getItem().getItemID() == currentItem.getItemID())
                foundProduct = product;
            iProduct++;
        }

        if (foundProduct != null) {
            /*if (completeQuantity > itemCurrentInventory)
                orderLine.setQuantity(itemCurrentInventory);
            else
                orderLine.setQuantity(completeQuantity);*/

            setQuantity(foundProduct, orderLine.getQuantity() + foundProduct.getQuantity(), itemCurrentInventory);

            //Calculate price
            /*Double price = currentItem.getPrice();
            if (currentItem.getDiscount() != null)
                price -= (price / 100) * currentItem.getDiscount().getDiscount();

            orderLine.setPrice(foundProduct.getPrice() + (price * orderLine.getQuantity()));*/

            setPrice(foundProduct, currentItem, foundProduct.getPrice());
        }
        else {
            orderLine.setItem(currentItem);
            /*if (orderLine.getQuantity() > itemCurrentInventory)
                orderLine.setQuantity(itemCurrentInventory);
            else
                orderLine.setQuantity(orderLine.getQuantity());*/

            setQuantity(orderLine, orderLine.getQuantity(), itemCurrentInventory);

            //Calculate price
            /*Double price = currentItem.getPrice();
            if (currentItem.getDiscount() != null)
                price -= (price / 100) * currentItem.getDiscount().getDiscount();

            orderLine.setPrice(price * orderLine.getQuantity());*/

            setPrice(orderLine, currentItem, 0.0);

            cart.add(orderLine);
        }


        //orderLine.setPrice(itemDAO.getByItemID(orderLine.getItemFK()).getPrice() * orderLine.getQuantity());
        //cart.add(orderLine);
        /*System.out.println("il y a " + basket.size() + " éléments");
        System.out.println("Element panier : " + basket.get(0).getQuantity() + " --- prix : " + itemDAO.getByItemID(basket.get(0).getItemFK()).getPrice() * basket.get(0).getQuantity());
        System.out.println("Page : " + currentURL + " --- Item ID : " + orderLine.getItemFK() +  " -- orderLineQuantity : " + orderLine.getQuantity());*/

        //model.addAttribute("itemAdded", "<div class='alert alert-success' role='alert'><spring:message code='itemAdded'/></div>");
        return "redirect:/shop/" + currentURL;
    }

    public void setQuantity(OrderLine orderLine, int completeQuantity, Integer itemCurrentInventory) {

        if (completeQuantity > itemCurrentInventory)
            orderLine.setQuantity(itemCurrentInventory);
        else
            orderLine.setQuantity(completeQuantity);
    }

    public void setPrice(OrderLine orderLine, Item currentItem, Double orderLinePrice) {
        Double price = currentItem.getPrice();
        if (currentItem.getDiscount() != null)
            price -= (price / 100) * currentItem.getDiscount().getDiscount();

        orderLine.setPrice(price * orderLine.getQuantity());
    }
}

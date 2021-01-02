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
import java.util.HashMap;
import java.util.Optional;

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
    public HashMap<Integer, OrderLine> addCartIntoSessionScope() {
        return new HashMap();
    }

    @RequestMapping(value="/proteins", method = RequestMethod.GET)
    public String protein(Model model){
        currentURL = "proteins";

        model.addAttribute("title", "Protéines");

        ArrayList<Item> items = this.itemDAO.getByCategory(1);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/muscledev", method = RequestMethod.GET)
    public String muscleDev(Model model){
        currentURL = "muscledev";

        model.addAttribute("title", "Développement musculaire");

        ArrayList<Item> items = this.itemDAO.getByCategory(2);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/energy", method = RequestMethod.GET)
    public String energy(Model model){
        currentURL = "energy";
        model.addAttribute("title", "Energie");

        ArrayList<Item> items = this.itemDAO.getByCategory(3);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/fatBurners", method = RequestMethod.GET)
    public String fatBurners(Model model){
        currentURL = "fatBurners";

        model.addAttribute("title", "Brûleurs de graisses");

        ArrayList<Item> items = this.itemDAO.getByCategory(4);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/vitamins", method = RequestMethod.GET)
    public String vitamins(Model model){
        currentURL = "vitamins";

        model.addAttribute("title", "Vitamines");

        ArrayList<Item> items = this.itemDAO.getByCategory(5);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/snackAndDrinks", method = RequestMethod.GET)
    public String snackAndDrinks(Model model){
        currentURL = "snackAndDrinks";

        model.addAttribute("title", "Snacks et boissons");

        ArrayList<Item> items = this.itemDAO.getByCategory(6);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(value="/accessories", method = RequestMethod.GET)
    public String accessories(Model model){
        currentURL = "accessories";

        model.addAttribute("title", "Accessoires");

        ArrayList<Item> items = this.itemDAO.getByCategory(7);
        model.addAttribute("items", items);

        model.addAttribute("orderLine", new OrderLine());

        return "integrated:items";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addItemToCart(Model model,
                              @Valid @ModelAttribute OrderLine orderLine,
                              @ModelAttribute(value = CART) HashMap<Integer, OrderLine> cart) {

        //Item reference
        Item currentItem = itemDAO.getByItemID(orderLine.getItemID());

        //CurrentInventory
        Integer itemCurrentInventory = currentItem.getCurrentInventory();

        //Product already in the cart
        Optional<OrderLine> existingOrderLine = cart.values()
                .stream()
                .filter(ol->ol.getItem().getItemID() == currentItem.getItemID()).findFirst();

        if (existingOrderLine.isPresent()) {

            setQuantity(existingOrderLine.get(), orderLine.getQuantity() + existingOrderLine.get().getQuantity(), itemCurrentInventory);

            setPrice(existingOrderLine.get(), currentItem, existingOrderLine.get().getPrice());
        }

        else {
            orderLine.setItem(currentItem);

            setQuantity(orderLine, orderLine.getQuantity(), itemCurrentInventory);


            setPrice(orderLine, currentItem, 0.0);

            cart.put(orderLine.getItem().getItemID(),orderLine);
        }

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

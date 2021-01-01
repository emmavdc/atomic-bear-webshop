package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.dataAccess.dao.ItemDataAccess;
import com.webshop.sportnutrition.model.Item;
import com.webshop.sportnutrition.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({"cart"})
public class CartController extends MasterController {

    private final ItemDataAccess itemDAO;

    @Autowired
    public CartController(ItemDataAccess itemDAO) {
        this.itemDAO = itemDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String cartDisplay(Model model){
        model.addAttribute("title", "Panier");
        model.addAttribute("minusProduct", new OrderLine());
        model.addAttribute("plusProduct", new OrderLine());
        model.addAttribute("removeProduct", new OrderLine());
        model.addAttribute("product", new OrderLine());
        return "integrated:cart";
    }

    @RequestMapping(value="/minusQuantity", method = RequestMethod.POST)
    public String minusQuantity(Model model,
                           @Valid @ModelAttribute OrderLine orderLine,
                           @ModelAttribute(value = "cart") ArrayList<OrderLine> cart) {

        //System.out.println("OrderLineID : " + orderLine.getOrderLineID() + " --- Cart : " +  cart.get(orderLine.getOrderLineID()-1) + " --- Quantity : " + orderLine.getQuantity());
        int cartIndex = orderLine.getOrderLineID()-1;
        if (orderLine.getQuantity() == 1)
            cart.remove(cartIndex);
        else {
            OrderLine currentOrderLine = cart.get(cartIndex);
            currentOrderLine.setQuantity(orderLine.getQuantity() - 1);

            calculatedPrice(currentOrderLine);
        }

        return "redirect:/cart";
    }

    @RequestMapping(value="/plusQuantity", method = RequestMethod.POST)
    public String plusQuantity(Model model,
                           @Valid @ModelAttribute OrderLine orderLine,
                           @ModelAttribute(value = "cart") ArrayList<OrderLine> cart) {

        OrderLine currentOrderLine = cart.get(orderLine.getOrderLineID()-1);
        Integer itemInventory = currentOrderLine.getItem().getCurrentInventory();
        if (currentOrderLine.getQuantity() < itemInventory) {
            currentOrderLine.setQuantity(orderLine.getQuantity() + 1);
            calculatedPrice(currentOrderLine);
        }

        return "redirect:/cart";
    }

    public void calculatedPrice(OrderLine currentOrderLine) {

        //Calculate new price
        Item currentItem = currentOrderLine.getItem();
        Double price = currentItem.getPrice();
        if (currentItem.getDiscount() != null)
            price -= (price / 100) * currentItem.getDiscount().getDiscount();

        currentOrderLine.setPrice(price * currentOrderLine.getQuantity());
    }

    @RequestMapping(value="/removeProduct", method = RequestMethod.POST)
    public String removeProduct(Model model,
                                @Valid @ModelAttribute OrderLine orderLine,
                                @ModelAttribute(value = "cart") ArrayList<OrderLine> cart) {

        cart.remove(orderLine.getOrderLineID()-1);

        return "redirect:/cart";
    }

    @RequestMapping(value="/placeOrder", method = RequestMethod.POST)
    public String placeOrder(Model model,
                                @Valid @ModelAttribute OrderLine orderLine,
                                @ModelAttribute(value = "cart") ArrayList<OrderLine> cart) {

        return "redirect:/cart";
    }
}

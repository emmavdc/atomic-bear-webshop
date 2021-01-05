package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.ItemDAO;
import com.webshop.sportnutrition.dataAccess.dao.ItemDataAccess;
import com.webshop.sportnutrition.model.Customer;
import com.webshop.sportnutrition.model.Item;
import com.webshop.sportnutrition.model.Order;
import com.webshop.sportnutrition.model.OrderLine;
import com.webshop.sportnutrition.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({"cart"})
public class CartController extends MasterController {

    private final ItemDataAccess itemDAO;
    private final OrderServiceInterface orderService;

    @ModelAttribute(Constants.CURRENT_ORDER)
    public Order order() {
        return new Order();
    }


    @Autowired
    public CartController(ItemDAO itemDAO, OrderServiceInterface orderService) {
        this.itemDAO = itemDAO;
        this.orderService = orderService;
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

    @RequestMapping(value="order", method = RequestMethod.GET)
    public String ConfirmOrder(Model model){
        model.addAttribute("title", "Confirmation commande");
        model.addAttribute("isOrderConfirmed", false);
        return "integrated:order";
    }

    @RequestMapping(value="order", method = RequestMethod.POST)
    public String PassOrder(Model model, @ModelAttribute Order order,
                            @ModelAttribute(value = "cart") HashMap<Integer, OrderLine> cart) {
        model.addAttribute("title", "Confirmation commande");
        Boolean isOrderConfirmed = false;

        order.setOrderLines(cart.values().stream().collect(Collectors.toCollection((ArrayList<OrderLine>::new))));

        ArrayList<String> returnCodes = orderService.SaveOrder(order);

        if (returnCodes.get(0) == "rcOrder01") {
            isOrderConfirmed = true;
            cart.clear();
        }
        model.addAttribute("isOrderConfirmed", isOrderConfirmed);
        model.addAttribute("returnCodesSaveOrder", returnCodes);

        return "integrated:order";
    }

    @RequestMapping(value="/minusQuantity", method = RequestMethod.POST)
    public String minusQuantity(Model model,
                           @Valid @ModelAttribute OrderLine orderLine,
                           @ModelAttribute(value = "cart") HashMap<Integer, OrderLine> cart) {

        //System.out.println("OrderLineID : " + orderLine.getOrderLineID() + " --- Cart : " +  cart.get(orderLine.getOrderLineID()-1) + " --- Quantity : " + orderLine.getQuantity());

        int cartIndex = orderLine.getItemID();
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
                           @ModelAttribute(value = "cart") HashMap<Integer, OrderLine> cart) {

        OrderLine currentOrderLine = cart.get(orderLine.getItemID());
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
                                @ModelAttribute(value = "cart") HashMap<Integer, OrderLine> cart) {

        cart.remove(orderLine.getItemID());

        return "redirect:/cart";
    }

    @RequestMapping(value="/placeOrder", method = RequestMethod.POST)
    public String placeOrder(Model model,
                                @Valid @ModelAttribute OrderLine orderLine,
                                @ModelAttribute(value = "cart") HashMap<Integer, OrderLine> cart) {

        return "redirect:/cart";
    }
}

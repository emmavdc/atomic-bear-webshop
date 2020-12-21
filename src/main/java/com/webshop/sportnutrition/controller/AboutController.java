package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/aboutUs")
public class AboutController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "A propos de nous");
        return "integrated:about";
    }
}

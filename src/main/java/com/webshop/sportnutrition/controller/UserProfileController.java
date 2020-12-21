package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/myAccount")
public class UserProfileController {

    @RequestMapping(method = RequestMethod.GET)
    public String account(Model model){
        model.addAttribute("title", "My account");
        return "integrated:userProfile";
    }
}

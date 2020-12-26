package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/goToLogin")
public class AbsLogController {

    @RequestMapping(method = RequestMethod.GET)
    public String goToLog (Model model) {
        return "redirect:/home";
    }
}

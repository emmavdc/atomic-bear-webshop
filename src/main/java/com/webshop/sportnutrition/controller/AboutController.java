package com.webshop.sportnutrition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/aboutUs")
public class AboutController extends MasterController {

    @Autowired
    public AboutController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String about(Model model){
        model.addAttribute("title", "about");
        return "integrated:about";
    }
}

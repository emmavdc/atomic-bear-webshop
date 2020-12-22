package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.CustomerDataAccess;
import com.webshop.sportnutrition.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value="/registration")
@SessionAttributes({Constants.CURRENT_USER})
public class UserInscriptionController {

    /*private HobbiesService hobbiesService;*/
    private CustomerDataAccess customerDAO;

    @Autowired
    public UserInscriptionController(/*HobbiesService hobbiesService,*/ CustomerDataAccess customerDAO) {
        /*this.hobbiesService = hobbiesService;*/
        this.customerDAO = customerDAO;
    }

    @ModelAttribute(Constants.CURRENT_USER)
    public Customer customer() {
        return new Customer();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String userReg (Model model) {
        model.addAttribute("title", "Inscription");
        model.addAttribute("registrationForm", customer());
        //model.addAttribute("hobbies", hobbiesService.getHobbies());
        return "integrated:userInscription";
    }

    @RequestMapping(value="/sendReg", method=RequestMethod.POST)
    public String getFormData(Model model,
                            @Valid @ModelAttribute(value= Constants.CURRENT_USER) Customer customer,
                            final BindingResult errors) throws ParseException {

        /* ------ Test match pwd ------ */
        if (!customer.getPassword().equals(customer.getConfirmPassword()))
            model.addAttribute("pwdDontMatch", "pwdDontMatch");

        //System.out.println("Date str : " + customer.getStrBirthDate());
        //System.out.println("Date :" + customer.getBirthDate());

        //if (customer.getStrBirthDate() != null) {

            // ------ Convert date from input field to date format ------
            //customer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse(customer.getStrBirthDate()));

            // ------ Convert date from input field to LocalDate format ------
            /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //d/MM/yyyy
            customer.setBirthDate(LocalDate.parse(customer.getStrBirthDate(), formatter));*/

            //System.out.println("Date str : " + customer.getStrBirthDate() + " --- Date convert : " + customer.getBirthDate() + " --- Y : " + customer.getBirthDate().getYear());
            /*LocalDate ld = LocalDate.parse("2019-02-14");
            System.out.println("The LocalDate is: " + ld);
            System.out.println("The year is: " + ld.getYear());*/

            /*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            LocalDate dateTime = LocalDate.parse(customer.getStrBirthDate(), formatter);
            System.out.println("Date convert :" + dateTime);*/

            // ------ Test if date is older than current date ------
            //Date currentDate = new Date();
            /*LocalDate currentDate = LocalDate.now();
            Boolean beforeCurrentDate = customer.getBirthDate().isBefore(currentDate); //customer.getBirthDate().compareTo(currentDate) > 0;
            Boolean ageIsValid = (currentDate.getYear() - customer.getBirthDate().getYear()) > 150;
            if (beforeCurrentDate && ageIsValid) {*/
            /*ObjectError error = new ObjectError("BirtDateError", "Birth date must be older than current date");
            errors.addError(error);*/
                /*model.addAttribute("birthDateError", "birthDateError");
            }
        }*/
        /*else
            model.addAttribute("birthDateError", "birthDateEmpty");*/

        //System.out.println("Date :" + customer.getBirthDate() + " ----- Str date : " + customer.getStrBirthDate());

        Customer customerBD = customerDAO.findByUsername(customer.getUsername());
        if(customerBD != null)
            model.addAttribute("usernameAlreadyExist", "usernameAlreadyExist");
        System.out.println("Customer = " + customerBD + " --- Customer exist : " + (customerBD != null));

        if (!errors.hasErrors() && !model.containsAttribute("pwdDontMatch") && !model.containsAttribute("usernameAlreadyExist")/* && !model.containsAttribute("birthDateError")*/) {

            //Remplissage ici car les valeurs de UserDetails ne se mappent pas correctement
            // Et les valeurs par défaut de la BD ne s'appliquent pas
            customer.setAccountNonExpired(true);
            customer.setAccountNonLocked(true);
            customer.setCredentialsNonExpired(true);
            customer.setEnabled(true);
            customer.setAuthorities("ROLE_USER");
            customer.setNbFidelityPoints(0);

            customerDAO.save(customer);
            model.addAttribute("log", customer.getUsername());
            model.addAttribute("pwd", customer.getPassword());
            //return "redirect:/myAccount";
            //return "redirect:/login";
            //return "redirect:/goToLogin";
            return "redirect:/home";

            //Renvoi une erreur (mettre le user en session ?)
            /*model.addAttribute("title", "Login");
            model.addAttribute("user", new Customer());
            return "integrated:login";*/
        }


        //System.out.println("Erreurs : " + errors);
            //return "integrated:gift";

        //String errorMsg = "Sorry, the form is not valid!";
        //model.addAttribute("message", errorMsg);
        //model.addAttribute("hobbies", hobbiesService.getHobbies());

        model.addAttribute("errors", errors);
        return "integrated:userInscription";
        //return "userInscription";

        //return "redirect/welcome";
    }


    /*public Boolean inscIsValid(String name, Integer age) {
        return (name.length() >= 4 && name.length() <= 15) && (age >= 1 && age <= 12);
    }*/
}

package com.webshop.sportnutrition.controller;

import com.webshop.sportnutrition.Constants;
import com.webshop.sportnutrition.dataAccess.dao.CategoryDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.CustomerDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.LanguageDataAccess;
import com.webshop.sportnutrition.dataAccess.dao.TranslationDataAccess;
import com.webshop.sportnutrition.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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
public class UserInscriptionController extends MasterController {

    private CustomerDataAccess customerDAO;

    @Autowired
    public UserInscriptionController(CustomerDataAccess customerDAO) {
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
        return "integrated:userInscription";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String getFormData(Model model,
                              @Valid @ModelAttribute(value= Constants.CURRENT_USER) Customer customer,
                              final BindingResult errors,
                              HttpServletRequest request) throws ServletException {

        /* ------ Test match pwd ------ */
        if (!customer.getPassword().equals(customer.getConfirmPassword()))
            model.addAttribute("pwdDontMatch", "pwdDontMatch");

        Customer customerBD = customerDAO.findByUsername(customer.getUsername());
        if(customerBD != null)
            model.addAttribute("usernameAlreadyExist", "usernameAlreadyExist");

        if (!errors.hasErrors() && !model.containsAttribute("pwdDontMatch") && !model.containsAttribute("usernameAlreadyExist")) {

            //Remplissage ici car les valeurs de UserDetails ne se mappent pas correctement
            // Et les valeurs par défaut de la BD ne s'appliquent pas
            customer.setAccountNonExpired(true);
            customer.setAccountNonLocked(true);
            customer.setCredentialsNonExpired(true);
            customer.setEnabled(true);
            customer.setAuthorities("ROLE_USER");
            customer.setNbFidelityPoints(0);

            customerDAO.save(customer);
            //return "redirect:/myAccount";
            //return "redirect:/login";
            //return "redirect:/goToLogin";
            authenticateUserAndSetSession(customer, request);
            return "redirect:/";
        }

        model.addAttribute("errors", errors);
        return "integrated:userInscription";
    }

    private void authenticateUserAndSetSession(Customer user, HttpServletRequest request) throws ServletException {
        String username = user.getUsername();
        String password = user.getPassword();

        request.login(username, password);
    }

}

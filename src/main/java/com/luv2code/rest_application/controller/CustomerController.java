package com.luv2code.rest_application.controller;

import com.luv2code.rest_application.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/customer/")
    public String showForm(Model model){
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/customer/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult){

        System.out.println("Last name : ["+customer.getLastName()+"]");
        if(bindingResult.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }

    }
}

package com.luv2code.rest_application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model){

        model.addAttribute("date", new java.util.Date());

        return "helloworld";
    }

    @GetMapping("/")
    public String showHome(){
        return "home";
    }
}

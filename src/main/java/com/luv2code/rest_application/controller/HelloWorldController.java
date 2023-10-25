package com.luv2code.rest_application.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld-processed";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        String name = request.getParameter("studentName");
        name=name.toUpperCase();
        String result = "Yo! "+name;

        model.addAttribute("message",result);

        return "helloworld-processed";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model){

        name=name.toUpperCase();
        String result = "Hey my friend "+name;

        model.addAttribute("message",result);

        return "helloworld-processed";
    }
}

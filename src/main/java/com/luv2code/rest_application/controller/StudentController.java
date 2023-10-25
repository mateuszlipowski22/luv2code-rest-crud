package com.luv2code.rest_application.controller;

import com.luv2code.rest_application.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @GetMapping("/showStudentForm")
    public String showForm(Model model){

        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student){

        System.out.println("Student : "+student.getFirstName()+" "+student.getLastName());
        return "student-confirmation";
    }
}

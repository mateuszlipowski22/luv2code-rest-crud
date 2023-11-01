package com.luv2code.rest_application.controller;

import com.luv2code.rest_application.entity.Employee;
import com.luv2code.rest_application.model.EmployeeDTO;
import com.luv2code.rest_application.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<EmployeeDTO> employees = employeeService.findAllDTO();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("employee", new EmployeeDTO());
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") EmployeeDTO employeeDTO,
               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employees/employee-form";
        }else {
            Employee employeeToSave= new Employee();
            if(Objects.nonNull(employeeDTO.getId())){
                employeeToSave.setId(employeeDTO.getId());
            }
            employeeToSave.setFirstName(employeeDTO.getFirstName());
            employeeToSave.setLastName(employeeDTO.getLastName());
            employeeToSave.setEmail(employeeDTO.getEmail());
            employeeService.save(employeeToSave);
            return "redirect:/employees/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id,
            Model model){
        model.addAttribute("employee", employeeService.findDTOById(id));
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}

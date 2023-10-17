package com.luv2code.rest_application.rest;

import com.luv2code.rest_application.entity.Employee;
import com.luv2code.rest_application.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{idEmployee}")
    public Employee getEmployee(@PathVariable int idEmployee){
        return employeeService.findById(idEmployee);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{idEmployee}")
    public void deleteEmployee(@PathVariable int idEmployee){
        employeeService.deleteById(idEmployee);
    }
}

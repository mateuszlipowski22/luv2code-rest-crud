package com.luv2code.rest_application.service;

import com.luv2code.rest_application.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int idEmployee);

}

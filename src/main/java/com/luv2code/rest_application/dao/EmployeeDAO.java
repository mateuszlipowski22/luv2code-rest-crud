package com.luv2code.rest_application.dao;

import com.luv2code.rest_application.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int idEmployee);

    Employee save(Employee employee);

    void deleteById(int idEmployee);
}

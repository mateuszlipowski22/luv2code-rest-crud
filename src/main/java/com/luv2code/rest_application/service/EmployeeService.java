package com.luv2code.rest_application.service;

import com.luv2code.rest_application.entity.Employee;
import com.luv2code.rest_application.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int idEmployee);

    EmployeeDTO findDTOById(int id);

    List<EmployeeDTO> findAllDTO();

    EmployeeDTO convertToDto(Employee employee);
}

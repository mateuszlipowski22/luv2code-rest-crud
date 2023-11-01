package com.luv2code.rest_application.service;

import com.luv2code.rest_application.dao.EmployeeRepository;
import com.luv2code.rest_application.entity.Employee;
import com.luv2code.rest_application.model.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee;
        if(result.isPresent()){
            employee=result.get();
        }else {
            throw new RuntimeException("Did not found employee id - "+id);
        }
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int idEmployee) {
        employeeRepository.deleteById(idEmployee);
    }

    @Override
    public EmployeeDTO findDTOById(int id) {
        return convertToDto(findById(id));
    }

    @Override
    public List<EmployeeDTO> findAllDTO() {
        return findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO convertToDto(Employee employee) {
        return EmployeeDTO.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .id(employee.getId())
                .email(employee.getEmail())
                .build();
    }
}

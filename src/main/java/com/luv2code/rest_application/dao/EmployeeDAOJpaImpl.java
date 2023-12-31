package com.luv2code.rest_application.dao;

import com.luv2code.rest_application.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int idEmployee) {
        Employee employee = entityManager.find(Employee.class, idEmployee);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee employeeDb = entityManager.merge(employee);
        return employeeDb;
    }

    @Override
    public void deleteById(int idEmployee) {
        Employee employee = entityManager.find(Employee.class, idEmployee);
        entityManager.remove(employee);
    }
}

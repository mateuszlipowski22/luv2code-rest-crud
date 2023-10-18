package com.luv2code.rest_application.dao;

import com.luv2code.rest_application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

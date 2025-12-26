package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Employee createEmployee(EmployeeDTO dto);

    Optional<Employee> updateEmployee(Long id, EmployeeDTO dto);

    void deleteEmployee(Long id);

    Optional<Employee> findByEmail(String email);
}

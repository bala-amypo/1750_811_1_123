package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    Employee getById(Long id);

    List<Employee> getAllActive();

    Employee update(Long id, Employee employee);

    void delete(Long id);
}

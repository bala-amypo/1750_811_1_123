package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee getById(Long id);
    List<Employee> getAll();
    Employee update(Long id, Employee employee);
    void delete(Long id);
}

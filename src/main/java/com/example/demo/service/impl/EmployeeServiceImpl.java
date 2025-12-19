package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> getAllActive() {
        return employeeRepository.findByActiveTrue();
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = getById(id);
        existing.setFullName(employee.getFullName());
        existing.setDepartment(employee.getDepartment());
        existing.setJobTitle(employee.getJobTitle());
        existing.setActive(employee.getActive());
        return employeeRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Employee employee = getById(id);
        employee.setActive(false);
        employeeRepository.save(employee);
    }
}

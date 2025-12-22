package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee save(Employee employee) {
        return repo.save(employee);
    }

    public Employee getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee update(Long id, Employee employee) {
        Employee e = getById(id);
        e.setFullName(employee.getFullName());
        e.setDepartment(employee.getDepartment());
        e.setJobTitle(employee.getJobTitle());
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

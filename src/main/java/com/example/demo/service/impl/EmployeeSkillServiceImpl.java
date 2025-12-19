package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepository) {
        this.employeeSkillRepository = employeeSkillRepository;
    }

    @Override
    public EmployeeSkill add(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getByEmployee(Long employeeId) {
        return employeeSkillRepository.findByEmployeeIdAndActiveTrue(employeeId);
    }

    @Override
    public List<Employee> searchEmployees(List<String> skills, Long userId) {
        return employeeSkillRepository.findEmployeesByAllSkillNames(skills, userId);
    }
}

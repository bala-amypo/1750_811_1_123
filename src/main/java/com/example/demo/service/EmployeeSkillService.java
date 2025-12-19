package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill add(EmployeeSkill employeeSkill);

    List<EmployeeSkill> getByEmployee(Long employeeId);

    List<Employee> searchEmployees(List<String> skills, Long userId);
}

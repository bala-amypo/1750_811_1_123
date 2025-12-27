package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill addEmployeeSkill(Long employeeId, Long skillId);

    List<EmployeeSkill> getSkillsForEmployee(Long employeeId);

    List<Employee> getEmployeesBySkill(Long skillId);

    void deactivateEmployeeSkill(Long employeeSkillId);
}

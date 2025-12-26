package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {

    List<EmployeeSkill> getAllEmployeeSkills();

    EmployeeSkill assignSkillToEmployee(Long employeeId, Long skillId, int rating);

    void removeSkillFromEmployee(Long employeeSkillId);

    List<EmployeeSkill> getSkillsByEmployee(Long employeeId);

    void deactivateEmployeeSkill(Long employeeSkillId);

    // Controller related methods
    EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill);

    List<EmployeeSkill> getSkillsForEmployee(Long employeeId);

    List<EmployeeSkill> getEmployeesBySkill(Long skillId);
}

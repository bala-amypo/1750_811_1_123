package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill addEmployeeSkill(Long employeeId, Long skillId);

    void deactivateEmployeeSkill(Long employeeSkillId);

    List<Employee> getEmployeesBySkill(Long skillId);
}

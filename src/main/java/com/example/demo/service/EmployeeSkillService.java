package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {
    EmployeeSkill save(EmployeeSkill employeeSkill);
    List<EmployeeSkill> getAll();
}

package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeSkillDTO;
import com.example.demo.model.Employee;
import com.example.demo.model.Skill;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepository;
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepository, EmployeeRepository employeeRepository, SkillRepository skillRepository) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public EmployeeSkill assignSkill(EmployeeSkillDTO dto) {
        Employee emp = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Skill skill = skillRepository.findById(dto.getSkillId())
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        EmployeeSkill employeeSkill = new EmployeeSkill();
        employeeSkill.setEmployee(emp);
        employeeSkill.setSkill(skill);
        employeeSkill.setActive(dto.isActive());
        employeeSkill.setYearsOfExperience(dto.getYearsOfExperience());

        return employeeSkillRepository.save(employeeSkill);
    }
}

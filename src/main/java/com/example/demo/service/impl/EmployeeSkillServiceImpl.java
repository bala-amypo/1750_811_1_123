package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository employeeSkillRepository;
    private final EmployeeRepository employeeRepository;
    private final SkillRepository skillRepository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository employeeSkillRepository,
                                    EmployeeRepository employeeRepository,
                                    SkillRepository skillRepository) {
        this.employeeSkillRepository = employeeSkillRepository;
        this.employeeRepository = employeeRepository;
        this.skillRepository = skillRepository;
    }

    @Override
    public EmployeeSkill addEmployeeSkill(Long employeeId, Long skillId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (!employee.isActive()) {
            throw new RuntimeException("Employee is inactive");
        }

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        EmployeeSkill employeeSkill = new EmployeeSkill();
        employeeSkill.setEmployee(employee);
        employeeSkill.setSkill(skill);
        employeeSkill.setActive(true);

        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {

        EmployeeSkill employeeSkill = employeeSkillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeSkill not found"));

        employeeSkill.setActive(false);
        employeeSkillRepository.save(employeeSkill);
    }
}

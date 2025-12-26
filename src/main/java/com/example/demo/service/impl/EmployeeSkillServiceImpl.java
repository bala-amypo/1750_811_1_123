package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.Skill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {

        Employee employee = employeeRepository.findById(employeeSkill.getEmployee().getId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Skill skill = skillRepository.findById(employeeSkill.getSkill().getId())
                .orElseThrow(() -> new RuntimeException("Skill not found"));

        if (!employee.getActive()) {
            throw new IllegalArgumentException("inactive employee");
        }

        if (!skill.getActive()) {
            throw new IllegalArgumentException("inactive skill");
        }

        employeeSkill.validate();
        employeeSkill.setActive(true);

        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return employeeSkillRepository.findByEmployeeIdAndActiveTrue(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return employeeSkillRepository.findBySkillIdAndActiveTrue(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long employeeSkillId) {
        EmployeeSkill es = employeeSkillRepository.findById(employeeSkillId)
                .orElseThrow(() -> new RuntimeException("EmployeeSkill not found"));

        es.setActive(false);
        employeeSkillRepository.save(es);
    }
}

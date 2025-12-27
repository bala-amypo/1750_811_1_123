package com.example.demo.service.impl;

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
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return employeeSkillRepository.findByEmployee_Id(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeeSkillsBySkill(Long skillId) {
        return employeeSkillRepository.findBySkill_Id(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill skill = employeeSkillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeSkill not found"));

        skill.setActive(false);
        employeeSkillRepository.save(skill);
    }
}

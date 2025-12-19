package com.example.demo.service.impl;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill skill) {
        return repository.save(skill);
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill skill) {
        skill.setId(id);
        return repository.save(skill);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return repository.findBySkillId(skillId);
    }

    @Override
    public void deactivateEmployeeSkill(Long id) {
        EmployeeSkill skill = repository.findById(id).orElseThrow();
        skill.setActive(false);
        repository.save(skill);
    }
}

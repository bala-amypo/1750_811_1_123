package com.example.demo.service.impl;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repo) {
        this.repo = repo;
    }

    public EmployeeSkill save(EmployeeSkill employeeSkill) {
        return repo.save(employeeSkill);
    }

    public List<EmployeeSkill> getAll() {
        return repo.findAll();
    }
}

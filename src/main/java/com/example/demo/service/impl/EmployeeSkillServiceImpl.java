package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.Skill;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillRepository.findAll();
    }

    @Override
    public EmployeeSkill assignSkillToEmployee(Long employeeId, Long skillId, int rating) {
        Employee emp = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        Skill skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new IllegalArgumentException("Skill not found"));

        if(emp.getActive() != null && emp.getActive()) {
            EmployeeSkill employeeSkill = new EmployeeSkill();
            employeeSkill.setEmployee(emp);
            employeeSkill.setSkill(skill);
            employeeSkill.setRating(rating);
            employeeSkill.setActive(true);
            return employeeSkillRepository.save(employeeSkill);
        } else {
            throw new IllegalStateException("Employee is not active");
        }
    }

    @Override
    public void removeSkillFromEmployee(Long employeeSkillId) {
        employeeSkillRepository.deleteById(employeeSkillId);
    }

    @Override
    public List<EmployeeSkill> getSkillsByEmployee(Long employeeId) {
        return employeeSkillRepository.findByEmployeeId(employeeId);
    }

    @Override
    public void deactivateEmployeeSkill(Long employeeSkillId) {
        EmployeeSkill empSkill = employeeSkillRepository.findById(employeeSkillId)
                .orElseThrow(() -> new IllegalArgumentException("EmployeeSkill not found"));
        empSkill.setActive(false);
        employeeSkillRepository.save(empSkill);
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getSkillsForEmployee(Long employeeId) {
        return employeeSkillRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return employeeSkillRepository.findBySkillId(skillId);
    }
}

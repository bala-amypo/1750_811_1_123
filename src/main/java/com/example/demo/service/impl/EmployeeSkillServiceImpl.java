package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.Skill;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SkillRepository;
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
        Optional<Employee> employeeOpt = employeeRepository.findById(employeeId);
        Optional<Skill> skillOpt = skillRepository.findById(skillId);

        if (employeeOpt.isPresent() && skillOpt.isPresent()) {
            Employee emp = employeeOpt.get();
            Skill skill = skillOpt.get();

            // Check if employee is active
            if(emp.getActive() != null && emp.getActive()) {
                EmployeeSkill employeeSkill = new EmployeeSkill();
                employeeSkill.setEmployee(emp);
                employeeSkill.setSkill(skill);
                employeeSkill.setRating(rating);
                return employeeSkillRepository.save(employeeSkill);
            } else {
                throw new IllegalStateException("Employee is not active");
            }
        } else {
            throw new IllegalArgumentException("Employee or Skill not found");
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
}

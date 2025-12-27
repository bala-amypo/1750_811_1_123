package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    // CREATE employee-skill mapping
    @PostMapping
    public EmployeeSkill createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.createEmployeeSkill(employeeSkill);
    }

    // GET skills of an employee
    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsForEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.getSkillsForEmployee(employeeId);
    }

    // GET employee-skills by skill
    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeeSkillsBySkill(@PathVariable Long skillId) {
        return employeeSkillService.getEmployeeSkillsBySkill(skillId);
    }

    // DEACTIVATE mapping
    @PutMapping("/{id}/deactivate")
    public void deactivateEmployeeSkill(@PathVariable Long id) {
        employeeSkillService.deactivateEmployeeSkill(id);
    }
}

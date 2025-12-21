package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {
    @Autowired
    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public EmployeeSkill addSkillToEmployee(@RequestBody EmployeeSkill mapping) {
        return employeeSkillService.createEmployeeSkill(mapping);
    }

    @PutMapping("/{id}")
    public EmployeeSkill updateEmployeeSkill(@PathVariable Long id,
                                             @RequestBody EmployeeSkill mapping) {
        return employeeSkillService.updateEmployeeSkill(id, mapping);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsForEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.getSkillsForEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(@PathVariable Long skillId) {
        return employeeSkillService.getEmployeesBySkill(skillId);
    }

    @DeleteMapping("/{id}")
    public void deactivateEmployeeSkill(@PathVariable Long id) {
        employeeSkillService.deactivateEmployeeSkill(id);
    }
}

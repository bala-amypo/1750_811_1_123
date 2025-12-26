package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class EmployeeSkillController {

    @Autowired
    private EmployeeSkillService employeeSkillService;

    @PostMapping
    public EmployeeSkill createEmployeeSkill(@RequestBody EmployeeSkill employeeSkill) {
        return employeeSkillService.createEmployeeSkill(employeeSkill);
    }

    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsForEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.getSkillsForEmployee(employeeId);
    }

    @GetMapping("/skill/{skillId}")
    public List<EmployeeSkill> getEmployeesBySkill(@PathVariable Long skillId) {
        return employeeSkillService.getEmployeesBySkill(skillId);
    }
}

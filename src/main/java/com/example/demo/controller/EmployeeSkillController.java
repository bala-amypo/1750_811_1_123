package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public ResponseEntity<EmployeeSkill> addEmployeeSkill(@RequestBody EmployeeSkill es) {
        EmployeeSkill created = employeeSkillService.createEmployeeSkill(es);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeSkill>> getSkillsForEmployee(@PathVariable Long employeeId) {
        List<EmployeeSkill> skills = employeeSkillService.getSkillsForEmployee(employeeId);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<EmployeeSkill>> getEmployeesBySkill(@PathVariable Long skillId) {
        List<EmployeeSkill> employees = employeeSkillService.getEmployeesBySkill(skillId);
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateEmployeeSkill(@PathVariable Long id) {
        employeeSkillService.deactivateEmployeeSkill(id);
        return ResponseEntity.noContent().build();
    }
}

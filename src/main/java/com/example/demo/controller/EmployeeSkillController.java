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

    // POST - assign skill to employee
    @PostMapping
    public ResponseEntity<EmployeeSkill> createEmployeeSkill(
            @RequestBody EmployeeSkill employeeSkill) {
        return ResponseEntity.ok(employeeSkillService.createEmployeeSkill(employeeSkill));
    }

    // GET - skills for employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeSkill>> getSkillsForEmployee(
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(
                employeeSkillService.getSkillsForEmployee(employeeId));
    }

    // GET - employees by skill
    @GetMapping("/skill/{skillId}")
    public ResponseEntity<List<EmployeeSkill>> getEmployeesBySkill(
            @PathVariable Long skillId) {
        return ResponseEntity.ok(
                employeeSkillService.getEmployeesBySkill(skillId));
    }

    // DELETE - deactivate mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deactivateEmployeeSkill(@PathVariable Long id) {
        employeeSkillService.deactivateEmployeeSkill(id);
        return ResponseEntity.ok("Employee skill mapping deactivated");
    }
}

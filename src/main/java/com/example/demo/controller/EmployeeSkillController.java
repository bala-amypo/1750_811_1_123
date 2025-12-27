package com.example.demo.controller;

import com.example.demo.model.Employee;
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

    // ✅ ADD SKILL TO EMPLOYEE
    @PostMapping("/{employeeId}/{skillId}")
    public EmployeeSkill addEmployeeSkill(@PathVariable Long employeeId,
                                          @PathVariable Long skillId) {
        return employeeSkillService.addEmployeeSkill(employeeId, skillId);
    }

    // ✅ GET SKILLS FOR EMPLOYEE
    @GetMapping("/employee/{employeeId}")
    public List<EmployeeSkill> getSkillsForEmployee(@PathVariable Long employeeId) {
        return employeeSkillService.getSkillsForEmployee(employeeId);
    }

    // ✅ GET EMPLOYEES BY SKILL
    @GetMapping("/skill/{skillId}")
    public List<Employee> getEmployeesBySkill(@PathVariable Long skillId) {
        return employeeSkillService.getEmployeesBySkill(skillId);
    }

    // ✅ DEACTIVATE EMPLOYEE SKILL
    @DeleteMapping("/{employeeSkillId}")
    public void deactivateEmployeeSkill(@PathVariable Long employeeSkillId) {
        employeeSkillService.deactivateEmployeeSkill(employeeSkillId);
    }
}

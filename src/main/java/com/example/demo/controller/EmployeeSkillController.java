package com.example.demo.controller;

import com.example.demo.dto.EmployeeSkillDTO;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService employeeSkillService;

    public EmployeeSkillController(EmployeeSkillService employeeSkillService) {
        this.employeeSkillService = employeeSkillService;
    }

    @PostMapping
    public EmployeeSkill assignSkill(@RequestBody EmployeeSkillDTO dto) {
        return employeeSkillService.assignSkill(dto);
    }
}

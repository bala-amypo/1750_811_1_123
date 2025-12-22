package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    private final EmployeeSkillService service;

    public EmployeeSkillController(EmployeeSkillService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeSkill create(@RequestBody EmployeeSkill employeeSkill) {
        return service.save(employeeSkill);
    }

    @GetMapping
    public List<EmployeeSkill> getAll() {
        return service.getAll();
    }
}

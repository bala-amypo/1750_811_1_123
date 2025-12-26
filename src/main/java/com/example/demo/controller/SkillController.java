package com.example.demo.controller;

import com.example.demo.dto.SkillDTO;
import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public Skill createSkill(@RequestBody SkillDTO dto) {
        return skillService.createSkill(dto);
    }
}

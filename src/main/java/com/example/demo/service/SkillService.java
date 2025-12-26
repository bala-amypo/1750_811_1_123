package com.example.demo.service;

import com.example.demo.dto.SkillDTO;
import com.example.demo.model.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillService {

    Optional<Skill> getSkillById(Long id);

    List<Skill> getAllSkills();

    Skill createSkill(SkillDTO dto);

    Optional<Skill> updateSkill(Long id, SkillDTO dto);

    void deleteSkill(Long id);
}

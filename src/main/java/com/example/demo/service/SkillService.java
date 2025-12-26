package com.example.demo.service;

import com.example.demo.model.Skill;

import java.util.List;

public interface SkillService {

    Skill createSkill(Skill skill);

    Skill updateSkill(Long id, Skill updatedSkill);

    Skill getSkillById(Long id);

    List<Skill> getAllSkills();

    void deactivateSkill(Long id);
}

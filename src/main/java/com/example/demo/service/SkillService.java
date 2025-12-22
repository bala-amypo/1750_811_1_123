// contains business logic of the application
// Validates data and applies rules
// Decides how the application works
package com.example.demo.service;

import com.example.demo.entity.Skill;

import java.util.List;

public interface SkillService {

    Skill createSkill(Skill skill);

    Skill updateSkill(Long id, Skill skill);

    Skill getSkillById(Long id);

    List<Skill> getAllSkills();

    void deactivateSkill(Long id);
}

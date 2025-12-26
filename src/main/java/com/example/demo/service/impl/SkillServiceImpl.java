package com.example.demo.service.impl;

import com.example.demo.dto.SkillDTO;
import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public Optional<Skill> getSkillById(Long id) {
        return skillRepository.findById(id);
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @Override
    public Skill createSkill(SkillDTO dto) {
        Skill skill = new Skill();
        skill.setName(dto.getName());
        skill.setCategoryId(dto.getCategoryId());
        return skillRepository.save(skill);
    }

    @Override
    public Optional<Skill> updateSkill(Long id, SkillDTO dto) {
        Optional<Skill> optionalSkill = skillRepository.findById(id);
        optionalSkill.ifPresent(skill -> {
            skill.setName(dto.getName());
            skill.setCategoryId(dto.getCategoryId());
            skillRepository.save(skill);
        });
        return optionalSkill;
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}

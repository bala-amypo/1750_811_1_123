package com.example.demo.service.impl;

import com.example.demo.dto.SkillDTO;
import com.example.demo.model.Skill;
import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillCategoryRepository categoryRepository;

    public SkillServiceImpl(SkillRepository skillRepository, SkillCategoryRepository categoryRepository) {
        this.skillRepository = skillRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Skill createSkill(SkillDTO dto) {
        Skill skill = new Skill();
        skill.setName(dto.getName());

        SkillCategory category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        skill.setCategory(category);

        return skillRepository.save(skill);
    }
}

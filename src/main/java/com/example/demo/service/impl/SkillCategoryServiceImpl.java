package com.example.demo.service.impl;

import com.example.demo.dto.SkillCategoryDTO;
import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository categoryRepository;

    public SkillCategoryServiceImpl(SkillCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategoryDTO dto) {
        SkillCategory category = new SkillCategory();
        category.setName(dto.getName());
        return categoryRepository.save(category);
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;

import java.util.List;

public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository skillCategoryRepository;

    public SkillCategoryServiceImpl(SkillCategoryRepository skillCategoryRepository) {
        this.skillCategoryRepository = skillCategoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return skillCategoryRepository.save(category);
    }

    @Override
    public SkillCategory updateCategory(Long id, SkillCategory category) {
        SkillCategory existing = skillCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setCategoryName(category.getCategoryName());
        existing.setActive(category.getActive());
        return skillCategoryRepository.save(existing);
    }

    @Override
    public void deactivateCategory(Long id) {
        SkillCategory existing = skillCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setActive(false);
        skillCategoryRepository.save(existing);
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepository.findAll();
    }
}

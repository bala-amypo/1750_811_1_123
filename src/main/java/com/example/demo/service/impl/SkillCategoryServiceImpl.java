package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;

import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository skillCategoryRepository;

    public SkillCategoryServiceImpl(SkillCategoryRepository skillCategoryRepository) {
        this.skillCategoryRepository = skillCategoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        category.setActive(true);
        return skillCategoryRepository.save(category);
    }

    @Override
    public SkillCategory getCategoryById(Long id) {
        return skillCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepository.findAll();
    }

    @Override
    public void deactivateCategory(Long id) {
        SkillCategory category = skillCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setActive(false);
        skillCategoryRepository.save(category);
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

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
    public SkillCategory updateCategory(Long id, SkillCategory category) {
        SkillCategory existing = skillCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setCategoryName(category.getCategoryName());
        return skillCategoryRepository.save(existing);
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
        SkillCategory existing = getCategoryById(id);
        existing.setActive(false);
        skillCategoryRepository.save(existing);
    }
}

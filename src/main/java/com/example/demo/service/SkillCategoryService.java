package com.example.demo.service;

import com.example.demo.entity.SkillCategory;

import java.util.List;

public interface SkillCategoryService {

    SkillCategory createCategory(SkillCategory category);

    SkillCategory updateCategory(Long id, SkillCategory category);

    SkillCategory getCategoryById(Long id);

    List<SkillCategory> getAllCategories();

    void deactivateCategory(Long id);
}

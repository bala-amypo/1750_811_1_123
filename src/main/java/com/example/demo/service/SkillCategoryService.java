package com.example.demo.service;

import com.example.demo.dto.SkillCategoryDTO;
import com.example.demo.model.SkillCategory;

import java.util.List;
import java.util.Optional;

public interface SkillCategoryService {

    Optional<SkillCategory> getCategoryById(Long id);

    List<SkillCategory> getAllCategories();

    SkillCategory createCategory(SkillCategoryDTO dto);

    Optional<SkillCategory> updateCategory(Long id, SkillCategoryDTO dto);

    void deleteCategory(Long id);
}

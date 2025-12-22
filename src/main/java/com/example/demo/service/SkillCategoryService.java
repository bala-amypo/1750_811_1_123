package com.example.demo.service;

import com.example.demo.model.SkillCategory;

import java.util.List;
import java.util.Optional;

public interface SkillCategoryService {

    SkillCategory saveCategory(SkillCategory category);

    List<SkillCategory> getAllCategories();

    Optional<SkillCategory> getCategoryByName(String categoryName);
}

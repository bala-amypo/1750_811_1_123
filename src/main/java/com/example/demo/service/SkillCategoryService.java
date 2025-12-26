package com.example.demo.service;

import com.example.demo.model.SkillCategory;
import java.util.List;

public interface SkillCategoryService {

    SkillCategory createCategory(SkillCategory category);

    SkillCategory updateCategory(Long id, SkillCategory category);

    void deactivateCategory(Long id);

    List<SkillCategory> getAllCategories();  // <-- must exist exactly like this
}

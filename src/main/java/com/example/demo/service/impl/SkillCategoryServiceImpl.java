package com.example.demo.service.impl;

import com.example.demo.dto.SkillCategoryDTO;
import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    @Autowired
    private SkillCategoryRepository categoryRepository;

    @Override
    public Optional<SkillCategory> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public SkillCategory createCategory(SkillCategoryDTO dto) {
        SkillCategory category = new SkillCategory();
        category.setName(dto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Optional<SkillCategory> updateCategory(Long id, SkillCategoryDTO dto) {
        Optional<SkillCategory> optionalCategory = categoryRepository.findById(id);
        optionalCategory.ifPresent(cat -> {
            cat.setName(dto.getName());
            categoryRepository.save(cat);
        });
        return optionalCategory;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

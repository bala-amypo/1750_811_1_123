package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository repository;

    public SkillCategoryServiceImpl(SkillCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillCategory create(SkillCategory category) {
        return repository.save(category);
    }

    @Override
    public List<SkillCategory> getAll() {
        return repository.findAll();
    }

    @Override
    public SkillCategory update(Long id, SkillCategory category) {
        SkillCategory existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        existing.setCategoryName(category.getCategoryName());
        existing.setDescription(category.getDescription());
        existing.setActive(category.getActive());
        return repository.save(existing);
    }
}

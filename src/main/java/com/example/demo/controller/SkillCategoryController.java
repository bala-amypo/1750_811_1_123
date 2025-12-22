package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class SkillCategoryController {

    private final SkillCategoryRepository skillCategoryRepository;

    public SkillCategoryController(SkillCategoryRepository skillCategoryRepository) {
        this.skillCategoryRepository = skillCategoryRepository;
    }

    // ➕ Add new skill category
    @PostMapping
    public SkillCategory addCategory(@RequestBody SkillCategory category) {
        return skillCategoryRepository.save(category);
    }

    // 📄 Get all categories
    @GetMapping
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepository.findAll();
    }

    // 🔍 Get category by name
    @GetMapping("/{name}")
    public SkillCategory getByName(@PathVariable String name) {
        return skillCategoryRepository
                .findByCategoryName(name)
                .orElse(null);
    }
}

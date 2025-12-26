package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SkillCategoryController {

    private final SkillCategoryService skillCategoryService;

    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }

    @PostMapping
    public SkillCategory createCategory(@RequestBody SkillCategory category) {
        return skillCategoryService.createCategory(category);
    }

    @GetMapping("/{id}")
    public SkillCategory getCategory(@PathVariable Long id) {
        return skillCategoryService.getCategoryById(id);
    }

    @GetMapping
    public List<SkillCategory> getAllCategories() {
        return skillCategoryService.getAllCategories();
    }

    @DeleteMapping("/{id}")
    public void deactivateCategory(@PathVariable Long id) {
        skillCategoryService.deactivateCategory(id);
    }
}

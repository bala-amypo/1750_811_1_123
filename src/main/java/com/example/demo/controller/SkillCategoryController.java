package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SkillCategoryController {

    @Autowired
    private final SkillCategoryService skillCategoryService;

    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }

    @PostMapping
    public SkillCategory createCategory(@RequestBody SkillCategory category) {
        return skillCategoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public SkillCategory updateCategory(@PathVariable Long id,
                                        @RequestBody SkillCategory category) {
        return skillCategoryService.updateCategory(id, category);
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

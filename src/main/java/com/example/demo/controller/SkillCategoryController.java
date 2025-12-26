package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class SkillCategoryController {

    private final SkillCategoryService skillCategoryService;

    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }

    // POST - create category
    @PostMapping
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(skillCategoryService.createCategory(category));
    }

    // GET - list categories
    @GetMapping
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(skillCategoryService.getAllCategories());
    }
}

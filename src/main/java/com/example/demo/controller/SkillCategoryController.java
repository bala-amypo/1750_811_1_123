package com.example.demo.controller;

import com.example.demo.dto.SkillCategoryDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService skillCategoryService;

    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }

    @PostMapping
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategoryDTO dto) {
        SkillCategory cat = new SkillCategory();
        cat.setCategoryName(dto.getCategoryName());
        SkillCategory created = skillCategoryService.createCategory(cat);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategoryById(@PathVariable Long id) {
        SkillCategory cat = skillCategoryService.getCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SkillCategory", "id", id));
        return ResponseEntity.ok(cat);
    }

    @GetMapping
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(skillCategoryService.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillCategory> updateCategory(@PathVariable Long id, @RequestBody SkillCategoryDTO dto) {
        SkillCategory cat = new SkillCategory();
        cat.setCategoryName(dto.getCategoryName());
        SkillCategory updated = skillCategoryService.updateCategory(id, cat);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deactivateCategory(@PathVariable Long id) {
        skillCategoryService.deactivateCategory(id);
        return ResponseEntity.noContent().build();
    }
}

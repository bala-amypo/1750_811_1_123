package com.example.demo.controller;

import com.example.demo.dto.SkillCategoryDTO;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @GetMapping("/{id}")
    public SkillCategory getCategoryById(@PathVariable Long id) {
        return skillCategoryService.getCategoryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    @GetMapping
    public List<SkillCategory> getAllCategories() {
        return skillCategoryService.getAllCategories();
    }

    @PostMapping
    public SkillCategory createCategory(@RequestBody SkillCategoryDTO dto) {
        return skillCategoryService.createCategory(dto);
    }

    @PutMapping("/{id}")
    public SkillCategory updateCategory(@PathVariable Long id, @RequestBody SkillCategoryDTO dto) {
        return skillCategoryService.updateCategory(id, dto)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        skillCategoryService.deleteCategory(id);
    }
}

package com.example.demo.controller;

import com.example.demo.dto.SkillCategoryDTO;
import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class SkillCategoryController {

    private final SkillCategoryService categoryService;

    public SkillCategoryController(SkillCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public SkillCategory createCategory(@RequestBody SkillCategoryDTO dto) {
        return categoryService.createCategory(dto);
    }
}

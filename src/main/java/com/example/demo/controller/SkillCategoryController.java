package com.example.demo.controller;

import com.example.demo.entity.SkillCategory;
import com.example.demo.service.SkillCategoryService;
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

    @PutMapping("/{id}")
    public SkillCategory updateCategory(@PathVariable Long id, @RequestBody SkillCategory category) {
        return skillCategoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        skillCategoryService.deleteCategory(id);
    }
}

package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService skillCategoryService;

    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }

    @PostMapping
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        return ResponseEntity.ok(skillCategoryService.createCategory(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
        return ResponseEntity.ok(skillCategoryService.getCategoryById(id));
    }

    @GetMapping
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        return ResponseEntity.ok(skillCategoryService.getAllCategories());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillCategory> updateCategory(
            @PathVariable Long id,
            @RequestBody SkillCategory category) {
        return ResponseEntity.ok(skillCategoryService.updateCategory(id, category));
    }
}

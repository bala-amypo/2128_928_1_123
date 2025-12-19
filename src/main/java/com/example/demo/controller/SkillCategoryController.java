package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.SkillCategory;
import com.example.demo.service.SkillCategoryService;

@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService categoryService;

    public SkillCategoryController(SkillCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public SkillCategory create(@Valid @RequestBody SkillCategory category) {
        return categoryService.create(category);
    }

    @GetMapping("/{id}")
    public SkillCategory getById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public List<SkillCategory> getAll() {
        return categoryService.getAll();
    }

    @PutMapping("/{id}")
    public SkillCategory update(@PathVariable Long id,
                                @Valid @RequestBody SkillCategory category) {
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}

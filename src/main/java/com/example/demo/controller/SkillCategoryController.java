package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

    private final SkillCategoryService service;

    public SkillCategoryController(SkillCategoryService service) {
        this.service = service;
    }

    @PostMapping
    public SkillCategory createCategory(@Valid @RequestBody SkillCategory category) {
        return service.createCategory(category);
    }

    @GetMapping("/{id}")
    public SkillCategory getCategoryById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @GetMapping
    public List<SkillCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @PutMapping("/{id}")
    public SkillCategory updateCategory(@PathVariable Long id,
                                        @Valid @RequestBody SkillCategory category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }
}

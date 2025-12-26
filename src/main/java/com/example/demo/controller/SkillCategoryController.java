package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-categories")
@Tag(name = "Skill Category Controller")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @PostMapping
    public SkillCategory create(@RequestBody SkillCategory category) {
        return skillCategoryService.create(category);
    }

    @PutMapping("/{id}")
    public SkillCategory update(@PathVariable Long id, @RequestBody SkillCategory category) {
        return skillCategoryService.update(id, category);
    }

    @GetMapping("/{id}")
    public SkillCategory getById(@PathVariable Long id) {
        return skillCategoryService.getById(id);
    }

    @GetMapping
    public List<SkillCategory> getAll() {
        return skillCategoryService.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        skillCategoryService.deactivate(id);
    }
}

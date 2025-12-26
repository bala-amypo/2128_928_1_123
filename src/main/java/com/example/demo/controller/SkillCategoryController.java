package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoryController {

    @PostMapping
    public Object createCategory(@RequestBody Object body) {
        return null;
    }

    @PutMapping("/{id}")
    public Object updateCategory(@PathVariable Long id,
                                 @RequestBody Object body) {
        return null;
    }

    @GetMapping("/{id}")
    public Object getCategory(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Object getAllCategories() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateCategory(@PathVariable Long id) {
    }
}

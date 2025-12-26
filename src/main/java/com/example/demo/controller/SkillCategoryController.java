package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skill-categories")
public class SkillCategoryController {

    @PostMapping
    public Object create() {
        return null;
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Object getAll() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
    }
}

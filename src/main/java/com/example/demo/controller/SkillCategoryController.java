package com.example.demo.controller;

import com.example.demo.entity.SkillCategory;
import com.example.demo.service.impl.SkillCategoryImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

@Autowired
private SkillCategoryImpl service;

@PostMapping
public SkillCategory createCategory(@Valid @RequestBody SkillCategory category) {
return service.create(category);
}
}

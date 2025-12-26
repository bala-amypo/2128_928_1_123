package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.SkillCategory;
import com.example.demo.service.SkillCategoryService;

@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

private final SkillCategoryService service;

public SkillCategoryController(SkillCategoryService service) {
this.service = service;
}

@PostMapping
public SkillCategory create(@RequestBody SkillCategory category) {
return service.save(category);
}

@GetMapping
public List<SkillCategory> getAll() {
return service.getAll();
}
}

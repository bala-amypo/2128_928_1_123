package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.impl.SkillImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillController {

@Autowired
private SkillImpl service;

@PostMapping
public Skill createSkill(@Valid @RequestBody Skill skill) {
return service.create(skill);
}

@GetMapping("/{id}")
public Skill getSkill(@PathVariable Long id) {
return service.getById(id);
}
}

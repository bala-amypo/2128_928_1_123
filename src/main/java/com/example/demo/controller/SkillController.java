package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@Tag(name = "Skill Controller")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @PostMapping
    public Skill create(@RequestBody Skill skill) {
        return skillService.create(skill);
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id, @RequestBody Skill skill) {
        return skillService.update(id, skill);
    }

    @GetMapping("/{id}")
    public Skill getById(@PathVariable Long id) {
        return skillService.getById(id);
    }

    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        skillService.deactivate(id);
    }
}

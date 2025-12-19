package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public Skill create(@Valid @RequestBody Skill skill) {
        return skillService.create(skill);
    }

    @GetMapping("/{id}")
    public Skill getById(@PathVariable Long id) {
        return skillService.getById(id);
    }

    @GetMapping
    public List<Skill> getAll() {
        return skillService.getAll();
    }

    @PutMapping("/{id}")
    public Skill update(@PathVariable Long id,
                        @Valid @RequestBody Skill skill) {
        return skillService.update(id, skill);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        skillService.delete(id);
    }
}

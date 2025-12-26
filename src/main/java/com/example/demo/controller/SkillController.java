package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id,
                             @RequestBody Skill skill) {
        return skillService.updateSkill(id, skill);
    }

    @GetMapping("/{id}")
    public Skill getSkill(@PathVariable Long id) {
        return skillService.findById(id);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.findAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateSkill(@PathVariable Long id) {
        skillService.deactivateSkill(id);
    }
}

package com.example.demo.controller;

import com.example.demo.entity.Skill;
import com.example.demo.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService service;

    public SkillController(SkillService service) {
        this.service = service;
    }

    @PostMapping
    public Skill createSkill(@Valid @RequestBody Skill skill) {
        return service.createSkill(skill);
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return service.getSkillById(id);
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return service.getAllSkills();
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id,
                             @Valid @RequestBody Skill skill) {
        return service.updateSkill(id, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        service.deleteSkill(id);
    }
}

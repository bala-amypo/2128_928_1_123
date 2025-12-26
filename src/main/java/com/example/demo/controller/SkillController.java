package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.createSkill(skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkill(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getSkillById(id));
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(
            @PathVariable Long id,
            @RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.updateSkill(id, skill));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Skill> deactivateSkill(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.deactivateSkill(id));
    }
}

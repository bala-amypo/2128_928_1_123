package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @Operation(
        summary = "Create skill",
        requestBody = @RequestBody(
            required = true,
            content = @Content(schema = @Schema(implementation = Skill.class))
        )
    )
    @PostMapping
    public Object createSkill(@org.springframework.web.bind.annotation.RequestBody Skill skill) {
        return skillService.create(skill);
    }

    @PutMapping("/{id}")
    public Object updateSkill(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Skill skill) {
        return skillService.update(id, skill);
    }

    @GetMapping("/{id}")
    public Object getSkill(@PathVariable Long id) {
        return skillService.getById(id);
    }

    @GetMapping
    public Object getAllSkills() {
        return skillService.getAll();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateSkill(@PathVariable Long id) {
        skillService.deactivate(id);
    }
}

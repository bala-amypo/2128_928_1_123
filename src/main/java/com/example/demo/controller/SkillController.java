package com.example.demo.controller;

import com.example.demo.model.Skill;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Operation(
        summary = "Create skill",
        requestBody = @RequestBody(
            required = true,
            content = @Content(schema = @Schema(implementation = Skill.class))
        )
    )
    @PostMapping
    public Object createSkill(
            @org.springframework.web.bind.annotation.RequestBody Skill skill) {
        return skill;
    }

    @PutMapping("/{id}")
    public Object updateSkill(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Skill skill) {
        return skill;
    }

    @GetMapping("/{id}")
    public Object getSkill(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Object getAllSkills() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateSkill(@PathVariable Long id) {
    }
}

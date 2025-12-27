package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillController {

    @PostMapping
    public Object createSkill(@RequestBody Object body) {
        return body;
    }

    @PutMapping("/{id}")
    public Object updateSkill(@PathVariable Long id,
                              @RequestBody Object body) {
        return body;
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

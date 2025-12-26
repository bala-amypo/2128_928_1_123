package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {

private final SkillService service;

public SkillController(SkillService service) {
this.service = service;
}

@PostMapping
public Skill create(@RequestBody Skill skill) {
return service.save(skill);
}

@GetMapping
public List<Skill> getAll() {
return service.getAll();
}
}

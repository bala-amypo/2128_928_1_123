package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

private final SkillRepository repository;

public SkillServiceImpl(SkillRepository repository) {
this.repository = repository;
}

@Override
public Skill createSkill(Skill skill) {
skill.setActive(true);
return repository.save(skill);
}

@Override
public Skill getSkillById(Long id) {
return repository.findById(id)
.orElseThrow(() -> new ResourceNotFoundException("Skill not found"));
}

@Override
public List<Skill> getAllSkills() {
return repository.findAll();
}

@Override
public Skill deactivateSkill(Long id) {
Skill skill = getSkillById(id);
skill.setActive(false);
return repository.save(skill);
}
}

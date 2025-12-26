package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;

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
.orElseThrow(() -> new ResourceNotFoundException("Skill not found with id " + id));
}

@Override
public List<Skill> getAllSkills() {
return repository.findAll();
}

@Override
public Skill updateSkill(Long id, Skill skill) {
Skill existing = getSkillById(id);
existing.setName(skill.getName());
existing.setCategory(skill.getCategory());
return repository.save(existing);
}

@Override
public void deleteSkill(Long id) {
Skill skill = getSkillById(id);
repository.delete(skill);
}

@Override
public Skill deactivateSkill(Long id) {
Skill skill = getSkillById(id);
skill.setActive(false);
return repository.save(skill);
}
}

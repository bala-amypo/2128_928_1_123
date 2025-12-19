package com.example.demo.service.impl;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepository;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillImpl implements SkillService {

private final SkillRepository skillRepository;

public SkillImpl(SkillRepository skillRepository) {
this.skillRepository = skillRepository;
}

@Override
public Skill createSkill(Skill skill) {
return skillRepository.save(skill);
}

@Override
public Skill getSkillById(Long id) {
return skillRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Skill not found with id: " + id));
}

@Override
public List<Skill> getAllSkills() {
return skillRepository.findAll();
}

@Override
public void deleteSkill(Long id) {
Skill skill = skillRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("Skill not found with id: " + id));

skillRepository.delete(skill);
}
}

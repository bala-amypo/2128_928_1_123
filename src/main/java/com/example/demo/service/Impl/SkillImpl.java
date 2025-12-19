package com.example.demo.service.impl;

import com.example.demo.entity.Skill;
import com.example.demo.repository.SkillRepo;
import com.example.demo.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillImpl implements SkillService {

    private final SkillRepo skillRepo;

    public SkillImpl(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public Skill getSkillById(Long id) {
        return skillRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepo.findAll();
    } 

    @Override
    public Skill updateSkill(Long id, Skill skill) {
        skill.setId(id);
        return skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }
}

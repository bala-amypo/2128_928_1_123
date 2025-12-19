package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Skill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillRepo;
import com.example.demo.service.SkillService;

@Service
public class SkillImpl implements SkillService {

    private final SkillRepo skillRepo;

    public SkillImpl(SkillRepo skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public Skill getById(Long id) {
        return skillRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Skill not found with id: " + id));
    }

    @Override
    public List<Skill> getAll() {
        return skillRepo.findAll();
    }

    @Override
    public Skill update(Long id, Skill skill) {
        Skill existing = getById(id);
        existing.setSkillName(skill.getSkillName());
        existing.setCategory(skill.getCategory());
        return skillRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        skillRepo.delete(getById(id));
    }
}

package com.example.demo.service;

import com.example.demo.model.Skill;

import java.util.List;

public interface SkillService {

    Skill createSkill(Skill skill);

    Skill getSkillById(Long id);

    List<Skill> getAllSkills();

    List<Skill> getActiveSkills();

    Skill updateSkill(Long id, Skill skill);

    Skill deactivateSkill(Long id);

    void deleteSkill(Long id);
}

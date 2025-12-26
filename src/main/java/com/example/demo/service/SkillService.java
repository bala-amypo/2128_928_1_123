package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;

public interface SkillService {

Skill saveSkill(Skill skill);

Skill getSkillById(Long id);

List<Skill> getAllSkills();

Skill deactivateSkill(Long id);
}

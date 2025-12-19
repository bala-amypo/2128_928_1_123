package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Skill;

public interface SkillService {

    Skill create(Skill skill);

    Skill getById(Long id);

    List<Skill> getAll();

    Skill update(Long id, Skill skill);

    void delete(Long id);
}

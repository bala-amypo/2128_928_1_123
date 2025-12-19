package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.SkillCategory;

public interface SkillCategoryService {

    SkillCategory create(SkillCategory category);

    SkillCategory getById(Long id);

    List<SkillCategory> getAll();

    SkillCategory update(Long id, SkillCategory category);

    void delete(Long id);
}

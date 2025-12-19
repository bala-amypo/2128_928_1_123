package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.SkillCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillCategoryRepo;
import com.example.demo.service.SkillCategoryService;

@Service
public class SkillCategoryImpl implements SkillCategoryService {

    private final SkillCategoryRepo categoryRepo;

    public SkillCategoryImpl(SkillCategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public SkillCategory create(SkillCategory category) {
        return categoryRepo.save(category);
    }

    @Override
    public SkillCategory getById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Skill category not found with id: " + id));
    }

    @Override
    public List<SkillCategory> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public SkillCategory update(Long id, SkillCategory category) {
        SkillCategory existing = getById(id);
        existing.setCategoryName(category.getCategoryName());
        return categoryRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.delete(getById(id));
    }
}

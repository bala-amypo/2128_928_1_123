package com.example.demo.service.impl;

import com.example.demo.entity.SkillCategory;
import com.example.demo.repository.SkillCategoryRepo;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryImpl implements SkillCategoryService {

    private final SkillCategoryRepo skillCategoryRepo;

    public SkillCategoryImpl(SkillCategoryRepo skillCategoryRepo) {
        this.skillCategoryRepo = skillCategoryRepo;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return skillCategoryRepo.save(category);
    }

    @Override
    public SkillCategory getCategoryById(Long id) {
        return skillCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepo.findAll();
    }

    @Override
    public SkillCategory updateCategory(Long id, SkillCategory category) {
        category.setId(id);
        return skillCategoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        skillCategoryRepo.deleteById(id);
    }
}

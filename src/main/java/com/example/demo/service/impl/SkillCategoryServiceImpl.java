package com.example.demo.service.impl;

import com.example.demo.model.SkillCategory;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;

import java.util.List;

public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository categoryRepository;

    public SkillCategoryServiceImpl(SkillCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        category.setActive(true);
        return categoryRepository.save(category);
    }

    @Override
    public SkillCategory updateCategory(Long id, SkillCategory category) {
        SkillCategory existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setCategoryName(category.getCategoryName());
        return categoryRepository.save(existing);
    }

    @Override
    public SkillCategory getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deactivateCategory(Long id) {
        SkillCategory category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setActive(false);
        categoryRepository.save(category);
    }
}

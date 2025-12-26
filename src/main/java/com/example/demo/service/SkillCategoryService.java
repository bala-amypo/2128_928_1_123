package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SkillCategory;

public interface SkillCategoryService {

SkillCategory createCategory(SkillCategory category);

SkillCategory getCategoryById(Long id);

List<SkillCategory> getAllCategories();

SkillCategory updateCategory(Long id, SkillCategory category);

void deleteCategory(Long id);
}

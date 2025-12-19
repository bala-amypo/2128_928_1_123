package com.example.demo.service.impl;

import com.example.demo.entity.SkillCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SkillCategoryRepository;
import com.example.demo.service.SkillCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryImpl implements SkillCategoryService {

private final SkillCategoryRepository skillCategoryRepository;

public SkillCategoryImpl(SkillCategoryRepository skillCategoryRepository) {
this.skillCategoryRepository = skillCategoryRepository;
}

@Override
public SkillCategory createCategory(SkillCategory category) {
return skillCategoryRepository.save(category);
}

@Override
public SkillCategory getCategoryById(Long id) {
return skillCategoryRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("SkillCategory not found with id: " + id));
}

@Override
public List<SkillCategory> getAllCategories() {
return skillCategoryRepository.findAll();
}

@Override
public void deleteCategory(Long id) {
SkillCategory category = skillCategoryRepository.findById(id)
.orElseThrow(() ->
new ResourceNotFoundException("SkillCategory not found with id: " + id));

skillCategoryRepository.delete(category);
}
}

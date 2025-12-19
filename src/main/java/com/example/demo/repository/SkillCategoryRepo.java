package com.example.demo.repository;

import com.example.demo.entity.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillCategoryRepo extends JpaRepository<SkillCategory, Long> {
}

package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "skill_categories")
public class SkillCategory {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Category name is required")
private String categoryName;

@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
private List<Skill> skills;

public SkillCategory() {}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getCategoryName() { return categoryName; }
public void setCategoryName(String categoryName) {
this.categoryName = categoryName;
}

public List<Skill> getSkills() { return skills; }
public void setSkills(List<Skill> skills) { this.skills = skills; }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Skill name required")
    private String skillName;

    @ManyToOne
    @NotNull(message = "Category required")
    private SkillCategory category;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillCategory getCategory() { return category; }
    public void setCategory(SkillCategory category) {
        this.category = category;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Skill name is required")
private String skillName;

@ManyToOne
@JoinColumn(name = "category_id")
private SkillCategory category;

@OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
private List<EmployeeSkill> employeeSkills;

public Skill() {}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getSkillName() { return skillName; }
public void setSkillName(String skillName) { this.skillName = skillName; }

public SkillCategory getCategory() { return category; }
public void setCategory(SkillCategory category) {
this.category = category;
}

public List<EmployeeSkill> getEmployeeSkills() {
return employeeSkills;
}
public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
this.employeeSkills = employeeSkills;
}
}

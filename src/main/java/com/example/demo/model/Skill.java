package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;

@ManyToOne
@JoinColumn(name = "category_id")
private SkillCategory category;

public Skill() {}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public SkillCategory getCategory() {
return category;
}

public void setCategory(SkillCategory category) {
this.category = category;
}
}

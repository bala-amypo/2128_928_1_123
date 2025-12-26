package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String name;

@ManyToOne
@JoinColumn(name = "category_id")
private SkillCategory category;

@Column(nullable = false)
private Boolean active = true;

public Skill() {}

public Skill(String name, SkillCategory category) {
this.name = name;
this.category = category;
this.active = true;
}

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

public Boolean getActive() {
return active;
}

public void setActive(Boolean active) {
this.active = active;
}
}

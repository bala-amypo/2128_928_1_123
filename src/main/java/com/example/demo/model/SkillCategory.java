package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_categories")
public class SkillCategory {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false, unique = true)
private String name;

@Column(nullable = false)
private Boolean active = true;

public SkillCategory() {}

public SkillCategory(String name) {
this.name = name;
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

public Boolean getActive() {
return active;
}

public void setActive(Boolean active) {
this.active = active;
}
}

package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkill {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "employee_id")
@NotNull
private Employee employee;

@ManyToOne
@JoinColumn(name = "skill_id")
@NotNull
private Skill skill;

@NotNull(message = "Proficiency level is required")
private Integer proficiencyLevel;

public EmployeeSkill() {}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public Employee getEmployee() { return employee; }
public void setEmployee(Employee employee) {
this.employee = employee;
}

public Skill getSkill() { return skill; }
public void setSkill(Skill skill) { this.skill = skill; }

public Integer getProficiencyLevel() {
return proficiencyLevel;
}
public void setProficiencyLevel(Integer proficiencyLevel) {
this.proficiencyLevel = proficiencyLevel;
}
}

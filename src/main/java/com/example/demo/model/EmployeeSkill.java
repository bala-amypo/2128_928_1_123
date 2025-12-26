package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkill {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "employee_id")
private Employee employee;

@ManyToOne
@JoinColumn(name = "skill_id")
private Skill skill;

private String proficiency;

private boolean active = true;

public EmployeeSkill() {}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public Employee getEmployee() {
return employee;
}

public void setEmployee(Employee employee) {
this.employee = employee;
}

public Skill getSkill() {
return skill;
}

public void setSkill(Skill skill) {
this.skill = skill;
}

public String getProficiency() {
return proficiency;
}

public void setProficiency(String proficiency) {
this.proficiency = proficiency;
}

public boolean isActive() {
return active;
}

public void setActive(boolean active) {
this.active = active;
}
}

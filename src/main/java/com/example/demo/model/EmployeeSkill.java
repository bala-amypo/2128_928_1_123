package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_skills",
uniqueConstraints = {
@UniqueConstraint(columnNames = {"employee_id", "skill_id"})
})
public class EmployeeSkill {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@ManyToOne
@JoinColumn(name = "employee_id", nullable = false)
private Employee employee;

@ManyToOne
@JoinColumn(name = "skill_id", nullable = false)
private Skill skill;

@Column(nullable = false)
private Integer proficiencyLevel;

public EmployeeSkill() {}

public EmployeeSkill(Employee employee, Skill skill, Integer proficiencyLevel) {
this.employee = employee;
this.skill = skill;
this.proficiencyLevel = proficiencyLevel;
}

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

public Integer getProficiencyLevel() {
return proficiencyLevel;
}

public void setProficiencyLevel(Integer proficiencyLevel) {
this.proficiencyLevel = proficiencyLevel;
}
}

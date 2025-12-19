package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Employee name is required")
private String name;

@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
private List<EmployeeSkill> employeeSkills;

public Employee() {}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getName() { return name; }
public void setName(String name) { this.name = name; }

public List<EmployeeSkill> getEmployeeSkills() { return employeeSkills; }
public void setEmployeeSkills(List<EmployeeSkill> employeeSkills) {
this.employeeSkills = employeeSkills;
}
}

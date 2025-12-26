package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill assignSkillToEmployee(EmployeeSkill employeeSkill);

    List<EmployeeSkill> getSkillsByEmployee(Long employeeId);

    List<EmployeeSkill> getEmployeesBySkill(Long skillId);

    List<Employee> searchEmployeesBySkills(List<String> skillNames);
}

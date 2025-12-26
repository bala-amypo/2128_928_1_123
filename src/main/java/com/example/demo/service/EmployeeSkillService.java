package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;

import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill);

    List<EmployeeSkill> getSkillsByEmployeeId(Long employeeId);

    List<EmployeeSkill> getEmployeesBySkillId(Long skillId);

    List<Employee> searchEmployeesBySkills(List<String> skills);
}

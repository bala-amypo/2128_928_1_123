package com.example.demo.service;

import com.example.demo.model.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {

EmployeeSkill assignSkillToEmployee(Long employeeId, Long skillId);

List<EmployeeSkill> getAllEmployeeSkills();
}

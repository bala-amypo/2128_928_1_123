package com.example.demo.service;

import com.example.demo.entity.EmployeeSkill;
import java.util.List;

public interface EmployeeSkillService {

    EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill);

    EmployeeSkill getEmployeeSkillById(Long id);

    List<EmployeeSkill> getAllEmployeeSkills();

    EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill);

    void deleteEmployeeSkill(Long id);
}

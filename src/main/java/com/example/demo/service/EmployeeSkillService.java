package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.EmployeeSkill;

public interface EmployeeSkillService {

    EmployeeSkill create(EmployeeSkill employeeSkill);

    EmployeeSkill getById(Long id);

    List<EmployeeSkill> getAll();

    EmployeeSkill update(Long id, EmployeeSkill employeeSkill);

    void delete(Long id);
}

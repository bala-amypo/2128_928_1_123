package com.example.demo.service.impl;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepo;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillImpl implements EmployeeSkillService {

    private final EmployeeSkillRepo employeeSkillRepo;

    public EmployeeSkillImpl(EmployeeSkillRepo employeeSkillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
        return employeeSkillRepo.save(employeeSkill);
    }

    @Override
    public EmployeeSkill getEmployeeSkillById(Long id) {
        return employeeSkillRepo.findById(id).orElse(null);
    }

    @Override
    public List<EmployeeSkill> getAllEmployeeSkills() {
        return employeeSkillRepo.findAll();
    }

    @Override
    public EmployeeSkill updateEmployeeSkill(Long id, EmployeeSkill employeeSkill) {
        employeeSkill.setId(id);
        return employeeSkillRepo.save(employeeSkill);
    }

    @Override
    public void deleteEmployeeSkill(Long id) {
        employeeSkillRepo.deleteById(id);
    }
}

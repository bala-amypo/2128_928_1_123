package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeSkill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeSkillRepo;
import com.example.demo.service.EmployeeSkillService;

@Service
public class EmployeeSkillImpl implements EmployeeSkillService {

    private final EmployeeSkillRepo employeeSkillRepo;

    public EmployeeSkillImpl(EmployeeSkillRepo employeeSkillRepo) {
        this.employeeSkillRepo = employeeSkillRepo;
    }

    @Override
    public EmployeeSkill create(EmployeeSkill employeeSkill) {
        return employeeSkillRepo.save(employeeSkill);
    }

    @Override
    public EmployeeSkill getById(Long id) {
        return employeeSkillRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "EmployeeSkill not found with id: " + id));
    }

    @Override
    public List<EmployeeSkill> getAll() {
        return employeeSkillRepo.findAll();
    }

    @Override
    public EmployeeSkill update(Long id, EmployeeSkill employeeSkill) {
        EmployeeSkill existing = getById(id);
        existing.setEmployee(employeeSkill.getEmployee());
        existing.setSkill(employeeSkill.getSkill());
        existing.setProficiencyLevel(employeeSkill.getProficiencyLevel());
        return employeeSkillRepo.save(existing);
    }

    @Override
    public void delete(Long id) {
        employeeSkillRepo.delete(getById(id));
    }
}

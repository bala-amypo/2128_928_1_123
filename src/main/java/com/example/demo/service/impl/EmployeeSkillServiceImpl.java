package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeSkill;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.EmployeeSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repository;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeSkill addEmployeeSkill(EmployeeSkill employeeSkill) {
        return repository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getSkillsByEmployeeId(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkillId(Long skillId) {
        return repository.findBySkillId(skillId);
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills) {
        if (skills == null || skills.isEmpty()) {
            throw new ResourceNotFoundException("Skill list cannot be empty");
        }
        return repository.findEmployeesByAllSkillNames(skills);
    }
}

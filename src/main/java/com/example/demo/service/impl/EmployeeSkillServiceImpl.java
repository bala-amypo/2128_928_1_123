package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
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
    public EmployeeSkill assignSkillToEmployee(EmployeeSkill employeeSkill) {
        return repository.save(employeeSkill);
    }

    @Override
    public List<EmployeeSkill> getSkillsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeSkill> getEmployeesBySkill(Long skillId) {
        return repository.findBySkillId(skillId);
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skillNames) {
        return repository.findEmployeesByAllSkillNames(skillNames);
    }
}

package com.example.demo.repository;

import com.example.demo.entity.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSkillRepo extends JpaRepository<EmployeeSkill, Long> {
}

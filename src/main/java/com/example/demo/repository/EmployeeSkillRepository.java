package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    // REQUIRED BY TEST CASE (exact name)
    @Query("""
        SELECT es.employee 
        FROM EmployeeSkill es
        WHERE es.skill.name IN :skills
          AND es.employee.active = true
          AND es.skill.active = true
        GROUP BY es.employee
        HAVING COUNT(DISTINCT es.skill.name) = :#{#skills.size()}
    """)
    List<Employee> findEmployeesByAllSkillNames(List<String> skills, Long userId);

    // REQUIRED BY TEST CASE
    List<EmployeeSkill> findByEmployeeIdAndActiveTrue(Long employeeId);

    // REQUIRED BY TEST CASE
    List<EmployeeSkill> findBySkillIdAndActiveTrue(Long skillId);
}

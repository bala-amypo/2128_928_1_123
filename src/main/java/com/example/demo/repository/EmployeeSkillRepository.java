package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

List<EmployeeSkill> findByEmployeeId(Long employeeId);

List<EmployeeSkill> findBySkillId(Long skillId);

/*
 * Find employees who have ALL given skill names
 */
@Query("""
SELECT es.employee.id
FROM EmployeeSkill es
WHERE es.skill.name IN :skills
GROUP BY es.employee.id
HAVING COUNT(DISTINCT es.skill.name) = :skillCount
""")
List<Object> findEmployeesByAllSkillNames(
@Param("skills") List<String> skills,
@Param("skillCount") long skillCount
);
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.EmployeeSkill;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

List<EmployeeSkill> findByEmployeeId(Long employeeId);

List<EmployeeSkill> findBySkillId(Long skillId);

@Query("""
SELECT es.employee
FROM EmployeeSkill es
WHERE es.skill.name IN :skillNames
GROUP BY es.employee
HAVING COUNT(DISTINCT es.skill.name) = :count
""")
List<Object> findEmployeesByAllSkillNames(
@Param("skillNames") List<String> skillNames,
@Param("count") long count
);
}

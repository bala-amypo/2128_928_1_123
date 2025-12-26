package com.example.demo.repository;

import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

List<EmployeeSkill> findByEmployeeId(Long employeeId);

List<EmployeeSkill> findBySkillId(Long skillId);

@Query("""
SELECT es.employee.id
FROM EmployeeSkill es
WHERE es.skill.name IN :names
AND es.active = true
GROUP BY es.employee.id
HAVING COUNT(DISTINCT es.skill.name) = :count
""")
List<Long> findEmployeeIdsBySkillNames(List<String> names, long count);
}

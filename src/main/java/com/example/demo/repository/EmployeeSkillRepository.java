package com.example.demo.repository;

import com.example.demo.model.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

    // Find all skills for a specific employee
    List<EmployeeSkill> findByEmployeeId(Long employeeId);

    // Find all employees who have a specific skill
    @Query("SELECT es FROM EmployeeSkill es WHERE es.skill.id = :skillId")
    List<EmployeeSkill> findBySkillId(@Param("skillId") Long skillId);

    // Find employees by all skill names for a specific employee
    @Query("SELECT es FROM EmployeeSkill es JOIN es.skill s WHERE s.name IN :skillNames AND es.employee.id = :employeeId")
    List<EmployeeSkill> findEmployeesByAllSkillNames(@Param("skillNames") List<String> skillNames,
                                                     @Param("employeeId") long employeeId);
}

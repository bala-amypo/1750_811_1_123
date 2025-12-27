package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final EmployeeSkillRepository employeeSkillRepository;

    public SearchQueryServiceImpl(EmployeeSkillRepository employeeSkillRepository) {
        this.employeeSkillRepository = employeeSkillRepository;
    }

    /**
     * Search employees who have ALL given skill IDs
     */
    @Override
    public List<Employee> searchEmployeesBySkillIds(List<Long> skillIds) {

        List<EmployeeSkill> mappings =
                employeeSkillRepository.findBySkillIdIn(skillIds);

        return mappings.stream()
                .filter(EmployeeSkill::isActive)
                .collect(Collectors.groupingBy(EmployeeSkill::getEmployee))
                .entrySet()
                .stream()
                .filter(e ->
                        e.getValue().stream()
                                .map(es -> es.getSkill().getId())
                                .collect(Collectors.toSet())
                                .containsAll(skillIds)
                )
                .map(e -> e.getKey())
                .distinct()
                .toList();
    }

    /**
     * Dummy implementation to satisfy interface
     * (you can improve later)
     */
    @Override
    public List<String> getQueriesForUser(Long userId) {
        return Collections.emptyList();
    }
}

package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Override
    public List<Employee> findEmployeesBySkills(List<String> skillNames, long employeeId) {
        // Fetch EmployeeSkill records
        List<EmployeeSkill> skillList = employeeSkillRepository.findEmployeesByAllSkillNames(skillNames, employeeId);

        // Extract Employee objects
        return skillList.stream()
                        .map(EmployeeSkill::getEmployee)
                        .collect(Collectors.toList());
    }
}

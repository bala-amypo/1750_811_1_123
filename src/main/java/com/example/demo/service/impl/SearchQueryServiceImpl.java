package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSkill;
import com.example.demo.model.SearchQuery;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    @Autowired
    private EmployeeSkillRepository employeeSkillRepository;

    @Autowired
    private SearchQueryRepository searchQueryRepository;

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skillNames, Long employeeId) {
        List<EmployeeSkill> skillList = employeeSkillRepository.findEmployeesByAllSkillNames(skillNames, employeeId);
        return skillList.stream()
                .map(EmployeeSkill::getEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public SearchQuery getQueryById(Long queryId) {
        return searchQueryRepository.findById(queryId).orElse(null);
    }

    @Override
    public List<SearchQuery> getQueriesForUser(Long userId) {
        return searchQueryRepository.findByUserId(userId);
    }
}

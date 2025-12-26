package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.EmployeeSkillRepository;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;

import java.util.List;
import java.util.stream.Collectors;

public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository searchQueryRecordRepository;
    private final EmployeeSkillRepository employeeSkillRepository;

    public SearchQueryServiceImpl(SearchQueryRecordRepository searchQueryRecordRepository,
                                  EmployeeSkillRepository employeeSkillRepository) {
        this.searchQueryRecordRepository = searchQueryRecordRepository;
        this.employeeSkillRepository = employeeSkillRepository;
    }

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skills, Long searcherId) {

        if (skills == null || skills.isEmpty()) {
            throw new IllegalArgumentException("Skills list must not be empty");
        }

        List<String> normalizedSkills = skills.stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        List<Employee> employees = employeeSkillRepository
                .findEmployeesByAllSkillNames(normalizedSkills, (long) normalizedSkills.size());

        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(searcherId);
        record.setSkillsRequested(String.join(",", normalizedSkills));
        record.setResultsCount((long) employees.size());

        searchQueryRecordRepository.save(record);

        return employees;
    }

    @Override
    public void saveQuery(SearchQueryRecord record) {
        searchQueryRecordRepository.save(record);
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        return searchQueryRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Query not found"));
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long searcherId) {
        return searchQueryRecordRepository.findBySearcherId(searcherId);
    }
}

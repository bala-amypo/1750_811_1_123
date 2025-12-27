package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    @Override
    public List<Employee> searchEmployeesBySkills(List<String> skillNames, Long userId) {
        // TEMP: return empty list (safe & compiles)
        return Collections.emptyList();
    }

    @Override
    public SearchQueryRecord getQueryById(Long id) {
        // TEMP dummy record
        SearchQueryRecord record = new SearchQueryRecord();
        record.setId(id);
        record.setCreatedAt(LocalDateTime.now());
        record.setSkills(Collections.emptyList());
        return record;
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return Collections.emptyList();
    }
}

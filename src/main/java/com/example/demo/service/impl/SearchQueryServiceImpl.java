package com.example.demo.service.impl;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository repository;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public void recordSearch(SearchQueryRecord record) {
        repository.save(record);
    }
    @Override
public List<Employee> searchEmployeesBySkills(List<String> skills, Long userId) {
    return List.of(); // temp
}

@Override
public SearchQuery getQueryById(Long id) {
    return repository.findById(id).orElseThrow();
}

@Override
public List<SearchQuery> getQueriesForUser(Long userId) {
    return repository.findAll();
}

}

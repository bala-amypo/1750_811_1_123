package com.example.demo.service.impl;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    private final SearchQueryRecordRepository repository;

    public SearchQueryServiceImpl(SearchQueryRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public SearchQueryRecord saveSearch(Long userId, List<String> skills) {
        SearchQueryRecord record = new SearchQueryRecord();
        record.setUserId(userId);
        record.setSkills(skills);
        record.setCreatedAt(LocalDateTime.now());

        return repository.save(record);
    }

    @Override
    public List<SearchQueryRecord> getQueriesForUser(Long userId) {
        return repository.findByUserId(userId);
    }
}

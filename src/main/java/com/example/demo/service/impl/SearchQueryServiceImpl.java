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
}

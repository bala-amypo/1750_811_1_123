package com.example.demo.service.impl;

import com.example.demo.dto.SearchQueryDTO;
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
    public SearchQueryRecord saveQuery(SearchQueryDTO dto, Long searcherId) {
        SearchQueryRecord record = new SearchQueryRecord();
        record.setQuery(dto.getQuery());
        record.setSearcherId(searcherId);
        return repository.save(record);
    }
}

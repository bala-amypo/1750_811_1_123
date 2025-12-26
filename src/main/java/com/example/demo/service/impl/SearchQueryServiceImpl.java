package com.example.demo.service.impl;

import com.example.demo.dto.SearchQueryDTO;
import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    @Autowired
    private SearchQueryRecordRepository repository;

    @Override
    public SearchQueryRecord createSearchQuery(SearchQueryDTO dto) {
        SearchQueryRecord record = new SearchQueryRecord();
        record.setSearcherId(dto.getSearcherId());
        record.setQuery(dto.getQuery());
        return repository.save(record);
    }

    @Override
    public List<SearchQueryRecord> getQueriesBySearcherId(Long searcherId) {
        return repository.findBySearcherId(searcherId);
    }
}

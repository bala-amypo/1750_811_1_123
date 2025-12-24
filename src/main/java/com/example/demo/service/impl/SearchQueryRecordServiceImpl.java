package com.example.demo.service.impl;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryRecordServiceImpl implements SearchQueryRecordService {

    private final SearchQueryRecordRepository searchQueryRecordRepository;

    public SearchQueryRecordServiceImpl(
            SearchQueryRecordRepository searchQueryRecordRepository) {
        this.searchQueryRecordRepository = searchQueryRecordRepository;
    }

    @Override
    public SearchQueryRecord saveSearchRecord(SearchQueryRecord record) {
        return searchQueryRecordRepository.save(record);
    }

    @Override
    public List<SearchQueryRecord> getAllSearchRecords() {
        return searchQueryRecordRepository.findAll();
    }

    @Override
    public List<SearchQueryRecord> getBySearchType(String searchType) {
        return searchQueryRecordRepository.findBySearchType(searchType);
    }

    @Override
    public List<SearchQueryRecord> getRecentSearches() {
        return searchQueryRecordRepository.findTop10ByOrderBySearchedAtDesc();
    }
}

package com.example.demo.service;

import com.example.demo.model.SearchQueryRecord;

import java.util.List;

public interface SearchQueryRecordService {

    SearchQueryRecord saveSearchRecord(SearchQueryRecord record);

    List<SearchQueryRecord> getAllSearchRecords();

    List<SearchQueryRecord> getBySearchType(String searchType);

    List<SearchQueryRecord> getRecentSearches();
}

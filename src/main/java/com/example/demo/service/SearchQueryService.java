package com.example.demo.service;

import com.example.demo.model.SearchQueryRecord;

import java.util.List;

public interface SearchQueryService {

    SearchQueryRecord saveSearch(Long userId, List<String> skills);

    List<SearchQueryRecord> getQueriesForUser(Long userId);
}

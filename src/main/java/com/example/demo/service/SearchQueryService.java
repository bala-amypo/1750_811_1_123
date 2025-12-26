package com.example.demo.service;

import com.example.demo.dto.SearchQueryDTO;
import com.example.demo.model.SearchQueryRecord;

import java.util.List;

public interface SearchQueryService {

    SearchQueryRecord createSearchQuery(SearchQueryDTO dto);

    List<SearchQueryRecord> getQueriesBySearcherId(Long searcherId);
}

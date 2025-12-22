package com.example.demo.repository;

import com.example.demo.model.SearchQueryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchQueryRecordRepository
        extends JpaRepository<SearchQueryRecord, Long> {

    // Get all searches of a type (Skill / Category)
    List<SearchQueryRecord> findBySearchType(String searchType);

    // Get recent searches
    List<SearchQueryRecord> findTop10ByOrderBySearchedAtDesc();
}

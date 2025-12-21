package com.example.demo.repository;

import com.example.demo.entity.SearchQueryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchQueryRecordRepository extends JpaRepository<SearchQueryRecord, Long> {

    List<SearchQueryRecord> findBySearcherId(Long searcherId);
}

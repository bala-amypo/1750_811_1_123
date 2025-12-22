package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_query_records")
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String searchType;   // Skill / Category / Skill+Level

    private String searchValue;  // Java / Backend / Backend-Expert

    private LocalDateTime searchedAt;

    public SearchQueryRecord() {
        this.searchedAt = LocalDateTime.now();
    }

    public SearchQueryRecord(String searchType, String searchValue) {
        this.searchType = searchType;
        this.searchValue = searchValue;
        this.searchedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSearchType() {
        return searchType;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public LocalDateTime getSearchedAt() {
        return searchedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public void setSearchedAt(LocalDateTime searchedAt) {
        this.searchedAt = searchedAt;
    }
}

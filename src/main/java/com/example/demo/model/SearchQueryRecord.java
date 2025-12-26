package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_query_records")
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long searcherId;

    @Column(nullable = false, length = 500)
    private String skillsRequested;

    private Long resultsCount = 0L;

    private LocalDateTime searchedAt;

    @PrePersist
    public void onCreate() {
        this.searchedAt = LocalDateTime.now();
        if (this.resultsCount == null) {
            this.resultsCount = 0L;
        }
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSearcherId() {
        return searcherId;
    }

    public void setSearcherId(Long searcherId) {
        this.searcherId = searcherId;
    }

    public String getSkillsRequested() {
        return skillsRequested;
    }

    public void setSkillsRequested(String skillsRequested) {
        this.skillsRequested = skillsRequested;
    }

    public Long getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(Long resultsCount) {
        this.resultsCount = resultsCount;
    }

    public LocalDateTime getSearchedAt() {
        return searchedAt;
    }
}

package com.example.demo.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "search_query_records")
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long searcherId;

    @Column(nullable = false)
    private String skillsRequested;

    private Integer resultsCount;

    @Column(updatable = false)
    private Timestamp searchedAt;

    @PrePersist
    protected void onCreate() {
        this.searchedAt = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Long getSearcherId() {
        return searcherId;
    }

    public String getSkillsRequested() {
        return skillsRequested;
    }

    public Integer getResultsCount() {
        return resultsCount;
    }

    public Timestamp getSearchedAt() {
        return searchedAt;
    }

    public void setSearcherId(Long searcherId) {
        this.searcherId = searcherId;
    }

    public void setSkillsRequested(String skillsRequested) {
        this.skillsRequested = skillsRequested;
    }

    public void setResultsCount(Integer resultsCount) {
        this.resultsCount = resultsCount;
    }
}

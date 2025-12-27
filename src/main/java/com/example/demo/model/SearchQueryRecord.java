package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "search_queries")
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private LocalDateTime createdAt;

    @ElementCollection
    @CollectionTable(
            name = "search_query_skills",
            joinColumns = @JoinColumn(name = "search_query_id")
    )
    @Column(name = "skill")
    private List<String> skills;

    // getters & setters
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}

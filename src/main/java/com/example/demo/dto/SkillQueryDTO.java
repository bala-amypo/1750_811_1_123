package com.example.demo.dto;

public class SearchQueryDTO {
    private Long searcherId;
    private String skillsRequested;

    // Getters and Setters
    public Long getSearcherId() { return searcherId; }
    public void setSearcherId(Long searcherId) { this.searcherId = searcherId; }
    public String getSkillsRequested() { return skillsRequested; }
    public void setSkillsRequested(String skillsRequested) { this.skillsRequested = skillsRequested; }
}

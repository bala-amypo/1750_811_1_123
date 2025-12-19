package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "skill_categories", uniqueConstraints = {
        @UniqueConstraint(columnNames = "categoryName")
})
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    private String description;

    private Boolean active = true;

    // Getters & Setters
    public Long getId() { return id; }
    public String getCategoryName() { return categoryName; }
    public String getDescription() { return description; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(Boolean active) { this.active = active; }
}

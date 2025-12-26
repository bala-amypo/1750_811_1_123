package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private SkillCategory category;

    // getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public SkillCategory getCategory() { return category; }

    // setters
    public void setName(String name) { this.name = name; }
    public void setCategory(SkillCategory category) { this.category = category; }
}

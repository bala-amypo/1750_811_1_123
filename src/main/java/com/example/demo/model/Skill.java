package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private SkillCategory category;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public SkillCategory getCategory() { return category; }
    public void setCategory(SkillCategory category) { this.category = category; }
}

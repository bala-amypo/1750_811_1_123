package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class EmployeeSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Skill skill;

    private int rating;     // <- add this field

    private Boolean active; // <- add this field to track active/inactive

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}

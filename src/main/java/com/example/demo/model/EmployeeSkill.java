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

    private boolean active;
    private int yearsOfExperience;

    public boolean getActive() { return active; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setActive(boolean active) { this.active = active; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }

    public Skill getSkill() { return skill; }
    public void setSkill(Skill skill) { this.skill = skill; }
}

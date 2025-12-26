package com.example.demo.dto;

public class EmployeeSkillDTO {
    private Long id;
    private Long employeeId;
    private Long skillId;
    private String proficiencyLevel;
    private Integer yearsOfExperience;
    private Boolean active;

    public EmployeeSkillDTO() {}

    public EmployeeSkillDTO(Long id, Long employeeId, Long skillId, String proficiencyLevel,
                            Integer yearsOfExperience, Boolean active) {
        this.id = id;
        this.employeeId = employeeId;
        this.skillId = skillId;
        this.proficiencyLevel = proficiencyLevel;
        this.yearsOfExperience = yearsOfExperience;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public Long getSkillId() { return skillId; }
    public void setSkillId(Long skillId) { this.skillId = skillId; }

    public String getProficiencyLevel() { return proficiencyLevel; }
    public void setProficiencyLevel(String proficiencyLevel) { this.proficiencyLevel = proficiencyLevel; }

    public Integer getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(Integer yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    @Override
    public String toString() {
        return "EmployeeSkillDTO{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", skillId=" + skillId +
                ", proficiencyLevel='" + proficiencyLevel + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", active=" + active +
                '}';
    }
}

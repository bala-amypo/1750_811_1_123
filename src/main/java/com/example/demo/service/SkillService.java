package com.example.demo.service;

import com.example.demo.model.Skill;
import java.util.List;

public interface SkillService {
    Skill save(Skill skill);
    List<Skill> getAll();
}

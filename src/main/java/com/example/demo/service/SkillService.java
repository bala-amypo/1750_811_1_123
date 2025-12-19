package com.example.demo.service;

import com.example.demo.model.Skill;

import java.util.List;

public interface SkillService {

    Skill create(Skill skill);

    Skill getById(Long id);

    List<Skill> getAllActive();

    Skill update(Long id, Skill skill);

    void delete(Long id);
}

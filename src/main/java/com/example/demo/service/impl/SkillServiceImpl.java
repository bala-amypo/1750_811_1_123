// package com.example.demo.service.impl;

// import com.example.demo.model.Skill;
// import com.example.demo.repository.SkillRepository;
// import com.example.demo.service.SkillService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class SkillServiceImpl implements SkillService {

//     private final SkillRepository skillRepository;

//     public SkillServiceImpl(SkillRepository skillRepository) {
//         this.skillRepository = skillRepository;
//     }

//     @Override
//     public Skill create(Skill skill) {
//         return skillRepository.save(skill);
//     }

//     @Override
//     public Skill getById(Long id) {
//         return skillRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Skill not found"));
//     }

//     @Override
//     public List<Skill> getAllActive() {
//         return skillRepository.findByActiveTrue();
//     }

//     @Override
//     public Skill update(Long id, Skill skill) {
//         Skill existing = getById(id);
//         existing.setName(skill.getName());
//         existing.setCategory(skill.getCategory());
//         existing.setDescription(skill.getDescription());
//         existing.setActive(skill.getActive());
//         return skillRepository.save(existing);
//     }

//     @Override
//     public void delete(Long id) {
//         Skill skill = getById(id);
//         skill.setActive(false);
//         skillRepository.save(skill);
//     }
// }

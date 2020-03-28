package com.olehhilchenko.service;

        import com.olehhilchenko.model.Skill;
        import com.olehhilchenko.repository.SkillRepository;
        import com.olehhilchenko.repository.jdbc.JDBCSkillRepositoryImpl;

public class SkillService {
    private SkillRepository skillRepository = new JDBCSkillRepositoryImpl();

    public void add(Skill skill) {
        skillRepository.insert(skill);
    }

    public void update(Skill skill) {
        skillRepository.update(skill);
    }

    public Skill get(Integer id) {
        return skillRepository.select(id);
    }

    public void remove(Skill skill) {
        skillRepository.delete(skill);
    }
}

package com.olehhilchenko.repository;

import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.repository.conection.DeveloperConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImplementation implements DeveloperRepository {

    private SkillRepositoryImplementation skillRepositoryImplementation = new SkillRepositoryImplementation();
    private DeveloperSkillRepositoryImplementation developerSkillRepositoryImplementation = new DeveloperSkillRepositoryImplementation();
    private SpecialtyRepositoryImplementation specialtyRepositoryImplementation = new SpecialtyRepositoryImplementation();
    private DeveloperSpecialtyRepositoryImplementation developerSpecialtyRepository = new DeveloperSpecialtyRepositoryImplementation();
    private DeveloperConnection developerConnection = new DeveloperConnection();


    public void insert(Developer developer) {
        List<DeveloperSkill> developerSkillList = new ArrayList<DeveloperSkill>();
        for (Skill skill : developer.getSkills()) {
            skillRepositoryImplementation.insert(skill);
            developerSkillList.add(new DeveloperSkill(developer.getId(), skill.getId()));
        }
        specialtyRepositoryImplementation.insert(developer.getSpecialty());
        developerSkillRepositoryImplementation.insert(developerSkillList);
        developerSpecialtyRepository.insert(new DeveloperSpecialty(developer.getId(), developer.getSpecialty().getId()));
        String sql = "INSERT INTO developer (id, first_name, last_name)\n" +
                "VALUES (" + developer.getId() + ", '" + developer.getFirstName() + "', '" + developer.getLastName() + "');";
        try {
            developerConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Developer developer) {
        String sql = "UPDATE developer SET first_name = '" + developer.getFirstName() + "', last_name = '" + developer.getLastName() + "' " +
                "WHERE id = " + developer.getId() + ";";
        try {
            developerConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        specialtyRepositoryImplementation.update(developer.getSpecialty());
        for (Skill skill : developer.getSkills()) {
            skillRepositoryImplementation.update(skill);
        }
    }

    public Developer select(Integer integer) {
        Developer developer = null;
        String sql = "SELECT id, first_name, last_name FROM developer WHERE id = " + integer + ";";
        try {
            developer = developerConnection.connection(sql, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DeveloperSpecialty developerSpecialty = developerSpecialtyRepository.select(developer.getId());
        List<DeveloperSkill> developerSkillList = developerSkillRepositoryImplementation.select(developer.getId());
        developer.setSpecialty(specialtyRepositoryImplementation.select(developerSpecialty.getSpecialtyId()));
        List<Skill> skillList = new ArrayList<Skill>();
        for (DeveloperSkill developerSkill : developerSkillList) {
            skillList.add(skillRepositoryImplementation.select(developerSkill.getSkillId()));
        }
        developer.setSkills(skillList);
        return developer;
    }

    public void delete(Developer developer) {
        String sql = "DELETE FROM developer\n" +
                "WHERE id = " + developer.getId() + ";";
        try {
            developerConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        developerSpecialtyRepository.delete(new DeveloperSpecialty(developer.getId(), developer.getSpecialty().getId()));
        List<DeveloperSkill> developerSkillList = new ArrayList<DeveloperSkill>();
        for (Skill skill : developer.getSkills()) {
            developerSkillList.add(new DeveloperSkill(developer.getId(), skill.getId()));
        }
        developerSkillRepositoryImplementation.delete(developerSkillList);
        specialtyRepositoryImplementation.delete(developer.getSpecialty());
        for (Skill skill : developer.getSkills()) {
            skillRepositoryImplementation.delete(skill);
        }
    }
}

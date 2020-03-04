package com.olehhilchenko.repository;

import com.olehhilchenko.model.Skill;
import com.olehhilchenko.repository.conection.SkillConnection;

import java.sql.SQLException;
import java.util.List;

public class SkillRepositoryImplementation implements SkillRepository {
    SkillConnection skillConnection = new SkillConnection();

    public void insert(Skill skill) {
        String SQL = "INSERT INTO skills (developerId, name)\n" +
                "VALUES ( " +skill.getId() + ", '" + skill.getName() + "');";
        try {
            skillConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Skill skill) {
    }

    public void update(Skill skill, String oldName){
        String SQL = "UPDATE skills SET name = '" + skill.getName() + "' WHERE" +
                " developerId = " + skill.getId() + " AND name = '" + oldName + "';";
        try {
            skillConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Skill select(Integer integer) {
        return null;
    }

    public List<Skill> selectSkillList(Integer developerId){
        List<Skill> skillList = null;
        String SQL = "SELECT developerId, name FROM skills WHERE" +
                " developerId = " + developerId + ";";
        try {
            skillList = skillConnection.connection(SQL, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    public void delete(Skill skill) {
        String SQL = "DELETE FROM skills WHERE" +
                " (developerId = " + skill.getId() + " AND name = '" + skill.getName() + "');";
        try {
            skillConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

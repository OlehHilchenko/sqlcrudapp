package com.olehhilchenko.repository;

import com.olehhilchenko.model.Skill;
import com.olehhilchenko.repository.conection.SkillConnection;

import java.sql.SQLException;

public class SkillRepositoryImplementation implements SkillRepository {
    private SkillConnection skillConnection = new SkillConnection();

    public void insert(Skill skill) {
        String sql = "INSERT INTO skills (id, name)\n" +
                "VALUES ( " +skill.getId() + ", '" + skill.getName() + "');";
        try {
            skillConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Skill skill) {
        String sql = "UPDATE skills SET name = '" + skill.getName() + "' WHERE" +
                " id = " + skill.getId() + ";";
        try {
            skillConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    public void update(Skill skill, String oldName){
        String SQL = "UPDATE skills SET name = '" + skill.getName() + "' WHERE" +
                " id = " + skill.getId() + ";";
        try {
            skillConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

    public Skill select(Integer integer) {
        Skill skill = null;
        String sql = "SELECT id, name FROM skills WHERE" +
                " id = " + integer + ";";
        try {
            skill = skillConnection.connection(sql, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    /*
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
    */

    public void delete(Skill skill) {
        String sql = "DELETE FROM skills WHERE" +
                " (id = " + skill.getId() + " AND name = '" + skill.getName() + "');";
        try {
            skillConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

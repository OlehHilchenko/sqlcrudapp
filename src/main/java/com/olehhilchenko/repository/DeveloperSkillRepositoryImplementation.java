package com.olehhilchenko.repository;

import com.olehhilchenko.repository.conection.DeveloperSkillConnection;

import java.sql.SQLException;
import java.util.List;

public class DeveloperSkillRepositoryImplementation implements DeveloperSkillRepository {
    private DeveloperSkillConnection developerSkillConnection = new DeveloperSkillConnection();

    public void insert(List<DeveloperSkill> developerSkills) {
        for (DeveloperSkill developerSkill : developerSkills) {
            String sql = "INSERT INTO developer_skills (developer_id, skill_id)\n" +
                    "VALUES (" + developerSkill.getDeveloperId() + ", " + developerSkill.getSkillId() + ");";
            try {
                developerSkillConnection.connection(sql, true, false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(List<DeveloperSkill> developerSkills) {

    }

    public List<DeveloperSkill> select(Integer integer) {
        List<DeveloperSkill> developerSkills = null;
        String sql = "SELECT developer_id, skill_id FROM developer_skills WHERE developer_id = " + integer + ";";
        try {
            developerSkills = developerSkillConnection.connection(sql, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developerSkills;
    }

    public void delete(List<DeveloperSkill> developerSkills) {
        for (DeveloperSkill developerSkill : developerSkills) {
            String sql = "DELETE FROM developer_skills\n" +
                    "WHERE (developer_id = " + developerSkill.getDeveloperId() + ");";
            try {
                developerSkillConnection.connection(sql, true, false);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

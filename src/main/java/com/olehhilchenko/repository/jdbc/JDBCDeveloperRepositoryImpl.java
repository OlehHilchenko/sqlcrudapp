package com.olehhilchenko.repository.jdbc;

import com.olehhilchenko.model.Developer;
import com.olehhilchenko.model.Skill;
import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.DeveloperRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public void insert(Developer developer) {
        String sql = "INSERT INTO developer (id, first_name, last_name)\n" +
                "VALUES (" + developer.getId() + ", '" + developer.getFirstName() + "', '" + developer.getLastName() + "');";
        String sql2 = "INSERT INTO developer_specialty (developer_id, specialty_id)\n" +
                "VALUES ( " + developer.getId() + ", '" + developer.getSpecialty().getId() + "');";
        List<String> sqlList = new ArrayList<>();
        sqlList.add(sql);
        sqlList.add(sql2);
        for (Skill skill : developer.getSkills()) {
            sqlList.add("INSERT INTO developer_skills (developer_id, skill_id)\n" +
                    "VALUES (" + developer.getId() + ", " + skill.getId() + ");");
        }
        String sqlArg[] = sqlList.toArray(new String[sqlList.size()]);
        execute(sqlArg);
    }

    @Override
    public void update(Developer developer) {
        String sql = "UPDATE developer SET first_name = '" + developer.getFirstName() + "', last_name = '" + developer.getLastName() + "' " +
                "WHERE id = " + developer.getId() + ";";
        execute(sql);
    }

    @Override
    public Developer select(Integer integer) {
        Developer developer = null;
        String sql = "SELECT d.id, d.first_name, d.last_name, ds.skill_id, dsp.specialty_id\n" +
                "FROM developer d\n" +
                "INNER JOIN (developer_skills ds, developer_specialty dsp) ON d.id = ds.developer_id AND d.id = dsp.developer_id\n" +
                "WHERE d.id = " + integer + "";
        try (Connection connection = RepositoryUtils.connection()) {
            Statement statement = connection.createStatement();
            developer = new Developer();
            ResultSet resultSet = statement.executeQuery(sql);
            boolean firstResSetString = true;
            List<Skill> skillList = new ArrayList<>();
            Specialty specialty = new Specialty();
            while (resultSet.next()) {
                if (firstResSetString) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    int specialtyId = resultSet.getInt("specialty_id");
                    developer.setId(id);
                    developer.setFirstName(firstName);
                    developer.setLastName(lastName);
                    specialty.setId(specialtyId);
                    firstResSetString = false;
                }
                int skillId = resultSet.getInt("skill_id");
                skillList.add(new Skill(skillId, null));
            }
            developer.setSpecialty(specialty);
            developer.setSkills(skillList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public void delete(Developer developer) {
        String sql = "DELETE FROM developer\n" +
                "WHERE id = " + developer.getId() + ";";
        String sql2 = "DELETE FROM developer_specialty\n" +
                "WHERE (developer_id = " + developer.getId() + ");";
        String sql3 = "DELETE FROM developer_skills\n" +
                "WHERE (developer_id = " + developer.getId() + ");";
        execute(sql, sql2, sql3);
    }

    private void execute(String... sql) {
        try (Connection connection = RepositoryUtils.connection()) {
            Statement statement = connection.createStatement();
            for (String s : sql) {
                statement.addBatch(s);
            }
            statement.executeBatch();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

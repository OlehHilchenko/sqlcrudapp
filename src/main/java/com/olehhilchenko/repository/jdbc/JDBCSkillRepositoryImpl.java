package com.olehhilchenko.repository.jdbc;

import com.olehhilchenko.model.Skill;
import com.olehhilchenko.repository.SkillRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSkillRepositoryImpl implements SkillRepository {

    @Override
    public void insert(Skill skill) {
        String sql = "INSERT INTO skills (id, name)\n" +
                "VALUES ( " + skill.getId() + ", '" + skill.getName() + "');";
        execute(sql);
    }

    @Override
    public void update(Skill skill) {
        String sql = "UPDATE skills SET name = '" + skill.getName() + "' WHERE" +
                " id = " + skill.getId() + ";";
        execute(sql);
    }

    @Override
    public Skill select(Integer integer) {
        Skill skill = null;
        String sql = "SELECT id, name FROM skills WHERE" +
                " id = " + integer + ";";
        try (Connection connection = RepositoryUtils.connection()) {
            skill = new Skill();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                skill.setId(id);
                skill.setName(name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void delete(Skill skill) {
        String sql = "DELETE FROM skills WHERE" +
                " (id = " + skill.getId() + " AND name = '" + skill.getName() + "');";
        execute(sql);
    }

    private void execute(String sql) {
        try (Connection connection = RepositoryUtils.connection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

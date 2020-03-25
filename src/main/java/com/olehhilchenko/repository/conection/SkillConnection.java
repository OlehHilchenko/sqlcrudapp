package com.olehhilchenko.repository.conection;

import com.olehhilchenko.model.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillConnection extends JDBCConnection<Skill> {

    @Override
    public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException {
        statement.executeUpdate(sql);
    }

    @Override
    public Skill select(String sql, Statement statement) throws SQLException {
        Skill skill = new Skill();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            skill.setId(id);
            skill.setName(name);
        }
        return skill;
    }
}

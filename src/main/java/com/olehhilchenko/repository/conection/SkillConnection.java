package com.olehhilchenko.repository.conection;

import com.olehhilchenko.model.Skill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillConnection extends JDBCConnection<List<Skill>> {

    @Override
    public void createOrDeleteOrUpdate(String SQL, Statement statement) throws SQLException {
        statement.executeUpdate(SQL);
    }

    @Override
    public List<Skill> select(String SQL, Statement statement) throws SQLException {
        List<Skill> skillList = new ArrayList<Skill>();
        Skill skill = new Skill();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            int developerId = resultSet.getInt("developerId");
            String name = resultSet.getString("name");
            skill.setId(developerId);
            skill.setName(name);
            skillList.add(skill);
            skill = new Skill();
        }
        return skillList;
    }
}

package com.olehhilchenko.repository.conection;

import com.olehhilchenko.repository.DeveloperSkill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeveloperSkillConnection extends JDBCConnection<List<DeveloperSkill>> {

    @Override
    public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException {
        statement.executeUpdate(sql);
    }

    @Override
    public List<DeveloperSkill> select(String sql, Statement statement) throws SQLException {
        List<DeveloperSkill> developerSkillList = new ArrayList<DeveloperSkill>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int developerId = resultSet.getInt("developer_id");
            int skillId = resultSet.getInt("skill_id");
            developerSkillList.add(new DeveloperSkill(developerId, skillId));
        }
        return developerSkillList;
    }
}

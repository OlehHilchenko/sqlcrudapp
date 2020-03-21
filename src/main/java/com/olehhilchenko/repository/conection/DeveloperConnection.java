package com.olehhilchenko.repository.conection;

import com.olehhilchenko.model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperConnection extends JDBCConnection<Developer> {

    @Override
    public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException {
        statement.executeUpdate(sql);
    }

    @Override
    public Developer select(String sql, Statement statement) throws SQLException {
        Developer developer = new Developer();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            developer.setId(id);
            developer.setFirstName(firstName);
            developer.setLastName(lastName);
        }
        return developer;
    }
}

package com.olehhilchenko.repository.conection;

import com.olehhilchenko.model.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperConnection extends JDBCConnection<Developer> {

    @Override
    public void createOrDeleteOrUpdate(String SQL, Statement statement) throws SQLException {
        statement.executeUpdate(SQL);
    }

    @Override
    public Developer select(String SQL, Statement statement) throws SQLException {
        Developer developer = new Developer();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            developer.setId(id);
            developer.setFirstName(firstName);
            developer.setLastName(lastName);
        }
        return developer;
    }
}

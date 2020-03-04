package com.olehhilchenko.repository.conection;

import com.olehhilchenko.model.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecialtyConnection extends JDBCConnection<Specialty> {

    @Override
    public void createOrDeleteOrUpdate(String SQL, Statement statement) throws SQLException {
        statement.executeUpdate(SQL);
    }

    @Override
    public Specialty select(String SQL, Statement statement) throws SQLException {
        Specialty specialty = new Specialty();
        ResultSet resultSet = statement.executeQuery(SQL);
        while (resultSet.next()) {
            int developerId = resultSet.getInt("developerId");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            specialty.setId(developerId);
            specialty.setName(name);
            specialty.setDescription(description);
        }
        return specialty;
    }
}

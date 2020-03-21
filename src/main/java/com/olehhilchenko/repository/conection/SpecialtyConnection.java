package com.olehhilchenko.repository.conection;

import com.olehhilchenko.model.Specialty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpecialtyConnection extends JDBCConnection<Specialty> {

    @Override
    public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException {
        statement.executeUpdate(sql);
    }

    @Override
    public Specialty select(String sql, Statement statement) throws SQLException {
        Specialty specialty = new Specialty();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            specialty.setId(id);
            specialty.setName(name);
            specialty.setDescription(description);
        }
        return specialty;
    }
}

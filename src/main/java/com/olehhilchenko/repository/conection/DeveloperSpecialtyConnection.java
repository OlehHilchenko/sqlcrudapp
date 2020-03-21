package com.olehhilchenko.repository.conection;

import com.olehhilchenko.repository.DeveloperSpecialty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperSpecialtyConnection extends JDBCConnection<DeveloperSpecialty> {

    @Override
    public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException {
        statement.executeUpdate(sql);
    }

    @Override
    public DeveloperSpecialty select(String sql, Statement statement) throws SQLException {
        DeveloperSpecialty developerSpecialty = new DeveloperSpecialty();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int developerId = resultSet.getInt("developer_id");
            int specialtyId = resultSet.getInt("specialty_id");
            developerSpecialty.setDeveloperId(developerId);
            developerSpecialty.setSpecialtyId(specialtyId);
        }
        return developerSpecialty;
    }
}

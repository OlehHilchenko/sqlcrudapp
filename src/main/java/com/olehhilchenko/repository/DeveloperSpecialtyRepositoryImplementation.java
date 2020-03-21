package com.olehhilchenko.repository;

import com.olehhilchenko.repository.conection.DeveloperSpecialtyConnection;

import java.sql.SQLException;

public class DeveloperSpecialtyRepositoryImplementation implements DeveloperSpecialtyRepository {
    private DeveloperSpecialtyConnection developerSpecialtyConnection = new DeveloperSpecialtyConnection();

    public void insert(DeveloperSpecialty developerSpecialty) {
        String sql = "INSERT INTO developer_specialty (developer_id, specialty_id)\n" +
                "VALUES ( " + developerSpecialty.getDeveloperId() + ", '" + developerSpecialty.getSpecialtyId() + "');";
        // INSERT INTO developer_specialty (developer_id, specialty_id) VALUES (5, 3);
        try {
            developerSpecialtyConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(DeveloperSpecialty developerSpecialty) {

    }

    public DeveloperSpecialty select(Integer integer) {
        DeveloperSpecialty developerSpecialty = null;
        String sql = "SELECT developer_id, specialty_id FROM developer_specialty WHERE developer_id = " + integer + ";";
        try {
            developerSpecialty = developerSpecialtyConnection.connection(sql, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developerSpecialty;
    }

    public void delete(DeveloperSpecialty developerSpecialty) {
        String sql = "DELETE FROM developer_specialty\n" +
                "WHERE (developer_id = " + developerSpecialty.getDeveloperId() + ");";
        try {
            developerSpecialtyConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

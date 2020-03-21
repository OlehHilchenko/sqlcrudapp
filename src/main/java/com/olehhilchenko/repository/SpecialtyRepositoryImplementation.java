package com.olehhilchenko.repository;

import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.conection.SpecialtyConnection;

import java.sql.SQLException;

public class SpecialtyRepositoryImplementation implements SpecialtyRepository {
    private SpecialtyConnection specialtyConnection = new SpecialtyConnection();

    public void insert(Specialty specialty) {
        String sql = "INSERT INTO specialty (id, name, description)\n" +
                "VALUES (" + specialty.getId() + ", '" + specialty.getName() + "', '" + specialty.getDescription() + "');";
        try {
            specialtyConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Specialty specialty) {
        String sql = "UPDATE specialty SET name = '" + specialty.getName() + "', description = '" + specialty.getDescription()+ "' WHERE" +
                " id = " + specialty.getId() + ";";
        try {
            specialtyConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Specialty select(Integer integer) {
        Specialty specialty = null;
        String sql = "SELECT id, name, description FROM specialty WHERE id = " + integer + ";";

        try {
            specialty = specialtyConnection.connection(sql, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

    public void delete(Specialty specialty) {
        String sql = "DELETE FROM specialty\n" +
                "WHERE id = " + specialty.getId() + ";";
        try {
            specialtyConnection.connection(sql, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

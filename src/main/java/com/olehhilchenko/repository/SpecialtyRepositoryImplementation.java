package com.olehhilchenko.repository;

import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.conection.SpecialtyConnection;

import java.sql.SQLException;

public class SpecialtyRepositoryImplementation implements SpecialtyRepository {
    private SpecialtyConnection specialtyConnection = new SpecialtyConnection();

    public void insert(Specialty specialty) {
        String SQL = "INSERT INTO specialty (developerId, name, description)\n" +
                "VALUES (" + specialty.getId() + ", '" + specialty.getName() + "', '" + specialty.getDescription() + "');";

        try {
            specialtyConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Specialty specialty) {
        String SQL = "UPDATE specialty SET name = '" + specialty.getName() + "', description = '" + specialty.getDescription()+ "' WHERE" +
                " developerId = " + specialty.getId() + ";";
        try {
            specialtyConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Specialty select(Integer integer) {
        Specialty specialty = null;
        String SQL = "SELECT developerId, name, description FROM specialty WHERE developerId = " + integer + ";";

        try {
            specialty = specialtyConnection.connection(SQL, false, true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

    public void delete(Specialty specialty) {
        String SQL = "DELETE FROM specialty\n" +
                "WHERE developerId = " + specialty.getId() + ";";

        try {
            specialtyConnection.connection(SQL, true, false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

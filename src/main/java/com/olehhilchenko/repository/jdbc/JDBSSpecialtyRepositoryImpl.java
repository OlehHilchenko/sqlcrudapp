package com.olehhilchenko.repository.jdbc;

import com.olehhilchenko.model.Specialty;
import com.olehhilchenko.repository.SpecialtyRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBSSpecialtyRepositoryImpl implements SpecialtyRepository {


    @Override
    public void insert(Specialty specialty) {
        String sql = "INSERT INTO specialty (id, name, description)\n" +
                "VALUES (" + specialty.getId() + ", '" + specialty.getName() + "', '" + specialty.getDescription() + "');";
        execute(sql);
    }

    @Override
    public void update(Specialty specialty) {
        String sql = "UPDATE specialty SET name = '" + specialty.getName() + "', description = '" + specialty.getDescription() + "' WHERE" +
                " id = " + specialty.getId() + ";";
        execute(sql);
    }

    @Override
    public Specialty select(Integer integer) {
        Specialty specialty = null;
        String sql = "SELECT id, name, description FROM specialty WHERE id = " + integer + ";";

        try (Connection connection = RepositoryUtils.connection()) {
            Statement statement = connection.createStatement();
            specialty = new Specialty();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                specialty.setId(id);
                specialty.setName(name);
                specialty.setDescription(description);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

    @Override
    public void delete(Specialty specialty) {
        String sql = "DELETE FROM specialty\n" +
                "WHERE id = " + specialty.getId() + ";";
        execute(sql);
    }

    private void execute(String sql) {
        try (Connection connection = RepositoryUtils.connection()) {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

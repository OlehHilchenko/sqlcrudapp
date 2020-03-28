package com.olehhilchenko.repository.jdbc;

import java.sql.*;

public class RepositoryUtils {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/csuser_db?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static int id;


    public static Connection connection() throws ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException s) {
            throw new RuntimeException("Error connecting to the database ", s);
        }
    }

    public static Integer getNextID() {
        String sql = "SELECT\n" +
                "  MAX(a.id),\n" +
                "  MAX(b.id),\n" +
                "  MAX(c.id)\n" +
                "FROM\n" +
                "  developer a,\n" +
                "  specialty b,\n" +
                "  skills c";


        if (id == 0) {
            try {
                Integer newId = 0;
                Statement statement = connection().createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    int getMaxDeveloperId = resultSet.getInt("MAX(a.id)");
                    if (newId < getMaxDeveloperId)
                        newId = getMaxDeveloperId;
                    int getMaxSpecialtyId = resultSet.getInt("MAX(b.id)");
                    if (newId < getMaxSpecialtyId)
                        newId = getMaxSpecialtyId;
                    int getMaxSkillId = resultSet.getInt("MAX(c.id)");
                    if (newId < getMaxSkillId)
                        newId = getMaxSkillId;
                }
                id = newId;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ++id;
    }
}


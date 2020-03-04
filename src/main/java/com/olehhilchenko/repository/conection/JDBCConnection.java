package com.olehhilchenko.repository.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class JDBCConnection<T> {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/csuser_db?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public T connection(String SQL, boolean createOrDeleteT, boolean selectT) throws ClassNotFoundException, SQLException {
        T t = null;
        Connection connection = null;
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("SQL request in progress...");
            statement = connection.createStatement();

            if (createOrDeleteT) {
                createOrDeleteOrUpdate(SQL, statement);
            } else if (selectT) {
                t = select(SQL, statement);
            }
            System.out.println("SQL request completed...");
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return t;
    }

    abstract public void createOrDeleteOrUpdate(String SQL, Statement statement) throws SQLException;

    abstract public T select(String SQL, Statement statement) throws SQLException;
}


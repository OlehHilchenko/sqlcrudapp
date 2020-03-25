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

    public T connection(String sql, boolean createOrDeleteT, boolean selectT) throws ClassNotFoundException, SQLException {
        T t = null;
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            statement = connection.createStatement();

            if (createOrDeleteT) {
                createOrDeleteOrUpdate(sql, statement);
            } else if (selectT) {
                t = select(sql, statement);
            }
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

    abstract public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException;

    abstract public T select(String sql, Statement statement) throws SQLException;
}


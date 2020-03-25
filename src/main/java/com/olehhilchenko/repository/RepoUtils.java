package com.olehhilchenko.repository;

import com.olehhilchenko.repository.conection.GetMaxIDConnection;

import java.sql.SQLException;

public class RepoUtils {
    private static int id;

    public static Integer getNextID() {
        GetMaxIDConnection getMaxIDConnection = new GetMaxIDConnection();
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
                id = getMaxIDConnection.connection(sql, false, true);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ++id;
    }
}

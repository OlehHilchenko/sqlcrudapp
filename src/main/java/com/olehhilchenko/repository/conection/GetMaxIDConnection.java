package com.olehhilchenko.repository.conection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetMaxIDConnection extends JDBCConnection<Integer>{

    @Override
    public void createOrDeleteOrUpdate(String sql, Statement statement) throws SQLException {

    }

    @Override
    public Integer select(String sql, Statement statement) throws SQLException {
        Integer newId = 1;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int getMaxDeveloperId = resultSet.getInt("MAX(a.id)");
            if(newId < getMaxDeveloperId)
                newId = getMaxDeveloperId;
            int getMaxSpecialtyId = resultSet.getInt("MAX(b.id)");
            if(newId < getMaxSpecialtyId)
                newId = getMaxSpecialtyId;
            int getMaxSkillId = resultSet.getInt("MAX(c.id)");
            if(newId < getMaxSkillId)
                newId = getMaxSkillId;
        }
        return newId;
    }
}

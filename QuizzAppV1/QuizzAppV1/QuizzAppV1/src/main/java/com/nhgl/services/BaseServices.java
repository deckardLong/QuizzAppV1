package com.nhgl.services;

import com.nhgl.utils.MyConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseServices<T> {
    public abstract PreparedStatement getStm(Connection conn) throws SQLException;
    public abstract List<T> getResults(ResultSet rs) throws SQLException;
    
    public List<T> list() throws SQLException {
        Connection conn = MyConnector.getInstance().connect();

        PreparedStatement stm = this.getStm(conn);
        
        return this.getResults(stm.executeQuery());
    }
}

package com.nhgl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnector {
    private static volatile MyConnector INSTANCE;
    private final Connection conn;
    
    static {
        try {    
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private MyConnector() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "Yuen311005"); 
    }
    
    public static MyConnector getInstance() throws SQLException {
        if (INSTANCE == null) {
            synchronized (MyConnector.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyConnector();
                }
            }
        }
        return INSTANCE;
    }
    
    public Connection connect() {
        return this.conn;
    }
    
    public void close() throws SQLException {
        if (this.conn != null) {
            this.conn.close();
        }
    }
 }

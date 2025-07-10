package com.nhgl.services;

import com.nhgl.pojo.Category;
import com.nhgl.utils.MyConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseServices<T> {
    public List<T> list() {
    Connection conn = MyConnector.getInstance().connect();
            
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM category");
            
            List<Category> cates = new ArrayList<>();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                
                Category c = new Category(id, name);
                cates.add(c);
            }
        return cates;
    }
}

package com.nhgl.services;

import com.nhgl.pojo.Question;
import com.nhgl.utils.MyConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateQuestionServices {
    public void addQuestion(Question q) throws SQLException {
        Connection conn = MyConnector.getInstance().connect();
        conn.setAutoCommit(false);
        
        String sql = "INSERT INTO question(content, hint, image, category_id, "
                + "level_id) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement stm = conn.prepareCall(sql);
        
        stm.setString(1, q.getContent());
        stm.setString(2, q.getHint());
        stm.setString(3, q.getImage());
        stm.setInt(4, q.getCategory().getId());
        stm.setInt(5, q.getCategory().getId());
        
        if (stm.executeUpdate() > 0) {
            int qId = -1;
            ResultSet r = stm.getGeneratedKeys();
            
            if (r.next())
                qId = r.getInt(1);
            
            sql = "INSERT INTO choice(content, is_correct, question_id) VALUES(?, ?, ?)";
            stm = conn.prepareCall(sql);
            
            for (var c: q.getChoices()) {
                stm.setString(1, c.getContent());
                stm.setBoolean(2, c.isCorrect());
                stm.setInt(3, qId);
                
                stm.executeUpdate();
            }
            
            conn.commit();
        } else 
            conn.rollback();
    }
}

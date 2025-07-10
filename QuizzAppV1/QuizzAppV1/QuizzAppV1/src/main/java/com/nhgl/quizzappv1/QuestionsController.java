package com.nhgl.quizzappv1;

import com.nhgl.pojo.Category;
import com.nhgl.services.CategoryServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class QuestionsController implements Initializable {
    @FXML private ComboBox<Category> cbCates;
    
    private final static CategoryServices cateService = new CategoryServices();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {          
            this.cbCates.setItems(FXCollections.observableList(cateService.getCates()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }      
}

package com.nhgl.quizzappv1;

import com.nhgl.utils.MyAlert;
import com.nhgl.utils.MyStage;
import com.nhgl.utils.themes.Theme;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable {
    @FXML private ComboBox<Theme> cbThemes;
    
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        MyStage.getInstance().showStage("Questions.fxml");
    }
    
    public void handlePratice(ActionEvent event) {
        MyAlert.getInstance().showMsg("Coming soon...");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    
    public void handleChangeThemes(ActionEvent event){
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme( this.cbThemes.getScene());
    }
}

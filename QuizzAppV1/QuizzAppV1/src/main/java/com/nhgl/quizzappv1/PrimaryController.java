package com.nhgl.quizzappv1;

import com.nhgl.utils.MyAlert;
import com.nhgl.utils.MyStage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class PrimaryController {
    public void handleQuestionManagement(ActionEvent event) throws IOException {
        MyStage.getInstance().showStage("Questions.fxml");
    }
    
    public void handlePratice(ActionEvent event) {
        MyAlert.getInstance().showMsg("Coming soon...");
    }
}

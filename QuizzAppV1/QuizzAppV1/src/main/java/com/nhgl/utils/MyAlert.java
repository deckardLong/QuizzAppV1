package com.nhgl.utils;

import javafx.scene.control.Alert;

public class MyAlert {
    private static volatile MyAlert INSTANCE;
    private final Alert alert;
    
    private MyAlert() {
        alert = new Alert(Alert.AlertType.INFORMATION);      
        alert.setTitle("Quizz App");
        alert.setHeaderText("Quizz App");
    }
    
    public static MyAlert getInstance() {
        if(INSTANCE == null) {
            synchronized (MyAlert.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyAlert();
                }
            }
        }
        return INSTANCE;
    }
    
    public void showMsg(String content) {
        alert.setContentText(content);
        alert.showAndWait();
    }
}

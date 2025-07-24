package com.nhgl.utils;

import com.nhgl.quizzappv1.App;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyStage {
   private static volatile MyStage INSTANCE;
   private final Stage stage;
   private static Scene scene;
   
   private MyStage() {
        stage = new Stage();
        stage.setTitle("Quizz App");
   }
   
   public static MyStage getInstance() {
       if (INSTANCE == null) {
           synchronized (MyStage.class) {
               if (INSTANCE == null) {
                   INSTANCE = new MyStage();
               }
           }
       }                 
       return INSTANCE;
   }
   
   public void showStage(String fxml) throws IOException {
       if (!stage.isShowing()) {
            if (scene == null) 
                scene = new Scene(new FXMLLoader(App.class.getResource(fxml)).load());

            else 
                scene.setRoot(new FXMLLoader(App.class.getResource(fxml)).load());

            stage.setScene(scene);
            stage.show();    
       }
   }
}

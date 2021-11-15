package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    Stage primaryStage;
    Scene scene;

    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void show(){
        primaryStage.show();
    }

    public void setScene(Scene scene){
        this.scene = scene;
    }


}

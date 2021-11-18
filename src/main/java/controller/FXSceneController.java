package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameState;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class FXSceneController {

    Stage primaryStage;
    GameController gameController;
    public static FXSceneController instance;

    public static FXSceneController getInstance(){
        if(instance == null) instance = new FXSceneController();
        return instance;
    }

    public void setPrimaryStage(Stage primaryStage){
        this.primaryStage = primaryStage;
    }

    public void setGameController(GameController gameController) {
        System.out.println(gameController);
        this.gameController = gameController;
    }

    public void switchInGame() throws IOException {
        Parent inGame = FXMLLoader.load(new File("src/main/java/view/FXMLViews/GUIView.fxml").toURI().toURL());
        Scene scene = new Scene(inGame);
        scene.setOnKeyPressed(gameController.getEventHandler());
        primaryStage.setScene(scene);
    }

    public void switchGameOver() throws IOException {
        Parent gameOver = FXMLLoader.load(new File("src/main/java/view/FXMLViews/GameOver.fxml").toURI().toURL());
        Scene scene = new Scene(gameOver);
        scene.setOnKeyPressed(gameController.getEventHandler());
        primaryStage.setScene(scene);
    }

    public void switchTitleScreen() throws IOException {
        Parent titleScreen = FXMLLoader.load(new File("src/main/java/view/FXMLViews/GameStart.fxml").toURI().toURL());
        Scene scene = new Scene(titleScreen);
        scene.setOnKeyPressed(gameController.getEventHandler());
        primaryStage.setScene(scene);
    }

    public void switchFightScreen() {

    }
}

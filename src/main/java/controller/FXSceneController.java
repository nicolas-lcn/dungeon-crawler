package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.GameState;
import view.GameOverView;
import view.GameView;
import view.TitleScreenView;

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
        this.gameController = gameController;
    }

    public void switchInGame() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((new File("src/main/java/view/FXMLViews/GUIView.fxml").toURI().toURL()));
        Parent inGame = fxmlLoader.load();
        Scene scene = new Scene(inGame);
        scene.setOnKeyPressed(gameController.getEventHandler());
        primaryStage.setScene(scene);
        gameController.setView(fxmlLoader.getController());
    }

    public void switchGameOver() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/java/view/FXMLViews/GameOver.fxml").toURI().toURL());
        Parent gameOver = fxmlLoader.load();
        Scene scene = new Scene(gameOver);
        scene.setOnKeyPressed(gameController.getEventHandler());
        primaryStage.setScene(scene);
        gameController.setView(fxmlLoader.getController());
    }

    public void switchTitleScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(new File("src/main/java/view/FXMLViews/GameStart.fxml").toURI().toURL());
        Parent titleScreen = fxmlLoader.load();
        Scene scene = new Scene(titleScreen);
        scene.setOnKeyPressed(gameController.getEventHandler());
        primaryStage.setScene(scene);
        gameController.setView(fxmlLoader.getController());
    }

    public void switchFightScreen() {

    }
}

package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Direction;
import model.GameState;
import model.Player;
import model.generators.SimpleComponentGenerator;
import model.generators.SimpleItemGenerator;
import model.places.Dungeon;
import model.places.SimpleDungeon;
import view.JavaFXView;
import view.View;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class App extends Application {
    /*

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages.
     * @throws Exception if something goes wrong
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Group root = new Group();
        JavaFXView view = new JavaFXView();
        Text message = view.text;
        root.getChildren().add(message);
        root.getChildren().add(new Canvas(400,200));
        Scene scene = new Scene(root);
        Player player = new Player(6,60);
        //JavaFXController javaFXController = new JavaFXController(player);
        scene.setOnKeyPressed(javaFXController.eventHandler);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }


}

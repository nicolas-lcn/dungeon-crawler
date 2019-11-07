package controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Player;
import view.JavaFXView;
import view.View;

public class App extends Application {
    /*public static void main(String[] args) {
        new KeyBoardController().read();
    }

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
        Group root = new Group();
        JavaFXView view = new JavaFXView();
        Text message = view.text;
        root.getChildren().add(message);
        Scene scene = new Scene(root);
        Player player = new Player(view);
        EventHandler<? super KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    player.goNorth(); break;
                    case DOWN:  player.goNorth(); break;
                    case LEFT:  player.goNorth(); break;
                    case RIGHT: player.goNorth(); break;
                }
            }
        } ;
        scene.setOnKeyPressed(eventHandler);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

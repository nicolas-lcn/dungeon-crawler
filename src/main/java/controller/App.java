package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Direction;
import model.GameState;
import model.Player;
import model.generators.SimpleComponentGenerator;
import model.generators.SimpleItemGenerator;
import model.places.SimpleDungeon;

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

        Player player = new Player(5,60);

        GameController javaFXController = new JavaFXController(player);
        FXSceneController fxSceneController = FXSceneController.getInstance();
        fxSceneController.setPrimaryStage(primaryStage);
        fxSceneController.setGameController(javaFXController);
        KeyBoardController keyBoardController = new KeyBoardController(javaFXController);
        javaFXController.setEventHandler(keyBoardController);
        javaFXController.initGameState();
        SimpleItemGenerator itemGenerator = new SimpleItemGenerator();
        SimpleComponentGenerator componentGenerator = new SimpleComponentGenerator(itemGenerator, GameState.getInstance());
        javaFXController.setComponentGenerator(componentGenerator);
        primaryStage.show();



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
        primaryStage.show();

        Parent inGame = FXMLLoader.load(new File("src/main/java/view/GUIView.fxml").toURI().toURL());
        Parent gameOver = FXMLLoader.load(new File("src/main/java/view/GameOver.fxml").toURI().toURL());
        Parent titleScreen = FXMLLoader.load(new File("src/main/java/view/GameStart.fxml").toURI().toURL());

        JavaFXView view = new JavaFXView();
        Player player = new Player(5,60);
        SimpleItemGenerator itemGenerator = new SimpleItemGenerator();
        SimpleComponentGenerator componentGenerator = new SimpleComponentGenerator(itemGenerator, GameState.getInstance());
        JavaFXController controller = new JavaFXController(player, view, componentGenerator);
        controller.initView(primaryStage, inGame, titleScreen, gameOver);
        view.setTitleScreen();
        view.show();
        view.setEventHandlers(controller.mouseEventHandler, controller.keyEventHandler);*/

    }


}

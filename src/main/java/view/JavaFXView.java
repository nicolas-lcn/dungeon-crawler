package view;

import controller.JavaFXController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.*;
import javafx.stage.Stage;
import model.Direction;
import model.GameState;
import model.Move;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class JavaFXView implements View{

    public AnchorPane GameVisualisation;
    public ImageView RoomViewer;
    public AnchorPane ComponentViewer;
    public ImageView ComponentImage;
    public ImageView MainUI;
    public AnchorPane WeaponAnchor;
    public ImageView WeaponImage;
    public AnchorPane PotionAnchor;
    public ImageView PotionImage;
    public ProgressBar HPBar;
    public TextArea GamestateViewer;
    public TextField NumberOfWeapon;
    public TextField NumberOfPotions;
    public TextField StrengthViewer;
    public Button East;
    public Button West;
    public Button South;
    public Button North;
    public MenuItem QuitButton;
    public Button StartButton;
    public Button QuitButtonTitleScreen;
    public final GameState gameState = GameState.getInstance();




    public void handleMove(Direction direction){
        System.out.println("Moving" + direction);
    }

    public void onClickNorth(){
        handleMove(Direction.North);
    }



    public void handleLook(Direction direction){
        System.out.println("Looking" + direction);
    }

    public void onQuit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onQuitScreen(MouseEvent mouseEvent) {
        Platform.exit();
    }

    public void startGame(MouseEvent mouseEvent) {
        gameState.resumeGame();
    }
}

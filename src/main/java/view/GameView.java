package view;

import controller.JavaFXController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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

public class GameView implements View{

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
    public final GameState gameState = GameState.getInstance();


    @Override
    public void startGame() {

    }

    @Override
    public void gameOver() {

    }

    @Override
    public void titleScreen() {

    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void beginFight() {

    }

    @Override
    public void stopFight() {

    }

    @Override
    public void quitGame() {

    }

    @Override
    public void setGameState() {

    }
}

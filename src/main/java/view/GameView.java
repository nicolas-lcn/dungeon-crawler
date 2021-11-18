package view;

import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import model.Direction;
import model.GameState;

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
    boolean isAnimationFinished;


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

    public void turnRight(){
        animateTurningRight();
    }

    public void turnLeft(){
        animateTurningLeft();
    }

    public void animateTurningRight(){

        //Creating Translate Transition
        TranslateTransition translateTransitionLeftToCenter = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionLeftToCenter.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionLeftToCenter.setNode(RoomViewer);

        //Setting the value of the transition along the x axis.
        translateTransitionLeftToCenter.setFromX(736);
        translateTransitionLeftToCenter.setToX(0);

        //Setting the cycle count for the transition
        translateTransitionLeftToCenter.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionLeftToCenter.setAutoReverse(false);

        //Creating Translate Transition
        TranslateTransition translateTransitionCenterToRight = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionCenterToRight.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionCenterToRight.setNode(RoomViewer);

        //Setting the value of the transition along the x axis.
        translateTransitionCenterToRight.setFromX(0);
        translateTransitionCenterToRight.setToX(-736);

        //Setting the cycle count for the transition
        translateTransitionCenterToRight.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionCenterToRight.setAutoReverse(false);


        SequentialTransition seqT = new SequentialTransition(translateTransitionCenterToRight, translateTransitionLeftToCenter);
        seqT.play();

    }

    public void animateTurningLeft(){

        //Creating Translate Transition
        TranslateTransition translateTransitionCenterToLeft = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionCenterToLeft.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionCenterToLeft.setNode(RoomViewer);

        //Setting the value of the transition along the x axis.
        translateTransitionCenterToLeft.setFromX(0);
        translateTransitionCenterToLeft.setToX(736);

        //Setting the cycle count for the transition
        translateTransitionCenterToLeft.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionCenterToLeft.setAutoReverse(false);

        //Creating Translate Transition
        TranslateTransition translateTransitionRightToCenter = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionRightToCenter.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionRightToCenter.setNode(RoomViewer);

        //Setting the value of the transition along the x axis.
        translateTransitionRightToCenter.setFromX(-736);
        translateTransitionRightToCenter.setToX(0);

        //Setting the cycle count for the transition
        translateTransitionRightToCenter.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionRightToCenter.setAutoReverse(false);


        SequentialTransition seqT = new SequentialTransition(translateTransitionCenterToLeft, translateTransitionRightToCenter);
        seqT.play();

    }

}

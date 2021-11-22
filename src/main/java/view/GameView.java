package view;

import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
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
    public Text NumberOfPotions;
    public Text StrengthViewer;
    public final GameState gameState = GameState.getInstance();
    public Text GameStateViewer;
    public Rectangle potionSelector;
    public Rectangle weaponSelector;
    public ImageView isWeaponEquipped;
    int selected;


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
        selected = 0;
        weaponSelector.setVisible(true);
        potionSelector.setVisible(false);
    }

    @Override
    public void closeInventory() {
        weaponSelector.setVisible(false);
        potionSelector.setVisible(false);
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

    @Override
    public void setRoomComponentImage(ImageView image) {
        ComponentImage.setImage(image.getImage());
    }

    @Override
    public void setUIText(String text) {
        GameStateViewer.setText(text);
    }

    @Override
    public void inventoryNavLeft() {
        if(selected == 0){
            selected = 1;
            weaponSelector.setVisible(false);
            potionSelector.setVisible(true);
        }else{
            selected = 0;
            weaponSelector.setVisible(true);
            potionSelector.setVisible(false);
        }
    }

    @Override
    public void inventoryNavRight() {
        if(selected == 0){
            selected = 1;
            weaponSelector.setVisible(false);
            potionSelector.setVisible(true);
        }else{
            selected = 0;
            weaponSelector.setVisible(true);
            potionSelector.setVisible(false);
        }
    }

    @Override
    public void setEquippedItemVisible() {
        isWeaponEquipped.setVisible(true);
    }

    @Override
    public void setNumberOfPotions(String numberOfPotions) {
        NumberOfPotions.setText(numberOfPotions);
    }


    public void animateTurningRight(){
        //Creating Translate Transition
        TranslateTransition translateTransitionLeftToCenter = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionLeftToCenter.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionLeftToCenter.setNode(GameVisualisation);

        //Setting the value of the transition along the x axis.
        translateTransitionLeftToCenter.setFromX(661);
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
        translateTransitionCenterToRight.setNode(GameVisualisation);

        //Setting the value of the transition along the x axis.
        translateTransitionCenterToRight.setFromX(0);
        translateTransitionCenterToRight.setToX(-841);

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
        translateTransitionCenterToLeft.setNode(GameVisualisation);

        //Setting the value of the transition along the x axis.
        translateTransitionCenterToLeft.setFromX(0);
        translateTransitionCenterToLeft.setToX(661);

        //Setting the cycle count for the transition
        translateTransitionCenterToLeft.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionCenterToLeft.setAutoReverse(false);

        //Creating Translate Transition
        TranslateTransition translateTransitionRightToCenter = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionRightToCenter.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionRightToCenter.setNode(GameVisualisation);

        //Setting the value of the transition along the x axis.
        translateTransitionRightToCenter.setFromX(-841);
        translateTransitionRightToCenter.setToX(0);

        //Setting the cycle count for the transition
        translateTransitionRightToCenter.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionRightToCenter.setAutoReverse(false);


        SequentialTransition seqT = new SequentialTransition(translateTransitionCenterToLeft, translateTransitionRightToCenter);
        seqT.play();

    }

}

package view;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.GameState;

import java.util.ArrayList;

public class GameView implements View{

    public AnchorPane GameVisualisation;
    public ImageView RoomViewer;
    public AnchorPane ComponentViewer;
    public ImageView ComponentImage;
    public ImageView MainUI;
    public Rectangle HPBar;
    public Text StrengthViewer;
    public Text GameStateViewer;
    public Rectangle secondItemSelector;
    public Rectangle firstItemSelector;
    public AnchorPane DoorAnchor;
    public AnchorPane FirstItemAnchor;
    public ImageView FirstItemImage;
    public AnchorPane SecondItemAnchor;
    public ImageView SecondItemImage;
    public Text FirstItemNumber;
    public ImageView FirstEquippedIcon;
    public Text SecondItemNumber;
    public ImageView SecondEquippedIcon;


    int selected;
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
        selected = 0;
        firstItemSelector.setVisible(true);
        secondItemSelector.setVisible(false);
    }

    @Override
    public void closeInventory() {
        firstItemSelector.setVisible(false);
        secondItemSelector.setVisible(false);
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
            firstItemSelector.setVisible(false);
            secondItemSelector.setVisible(true);
        }else{
            selected = 0;
            firstItemSelector.setVisible(true);
            secondItemSelector.setVisible(false);
        }
    }

    @Override
    public void inventoryNavRight() {
        if(selected == 0){
            selected = 1;
            firstItemSelector.setVisible(false);
            secondItemSelector.setVisible(true);
        }else{
            selected = 0;
            firstItemSelector.setVisible(true);
            secondItemSelector.setVisible(false);
        }
    }

    @Override
    public void setEquippedItemVisible(int index) {
        if(index==0) FirstEquippedIcon.setVisible(true);
        if(index==1) SecondEquippedIcon.setVisible(true);
    }

    @Override
    public void setNumberOfItems(ArrayList<Integer> itemsNumbers) {
        FirstItemNumber.setText(String.valueOf(itemsNumbers.get(0)));
        if(itemsNumbers.size()>=2)
            SecondItemNumber.setText(String.valueOf(itemsNumbers.get(1)));
    }

    @Override
    public void setNumberVisible(int index) {
        if(index==0) FirstItemNumber.setVisible(true);
        if(index==1) SecondItemNumber.setVisible(true);
    }

    @Override
    public void playerAttack() {

    }

    @Override
    public void enemyAttack() {

    }

    @Override
    public void waitToClear(int millis) {
        Timeline waitAnimation = new Timeline(new KeyFrame(Duration.millis(millis)));
        waitAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearRoomComponentImage();
                setUIText("");
            }
        });
        waitAnimation.play();
    }

    @Override
    public void waitToShow(int millis, boolean hasToShow) {
        Timeline waitAnimation = new Timeline(new KeyFrame(Duration.millis(millis)));
        waitAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(hasToShow) showDoor();
                else hideDoor();
            }
        });
        waitAnimation.play();
    }

    @Override
    public void updateHPBar(int remainingVitality, int maxVitality) {
        HPBar.setWidth(remainingVitality*245/maxVitality);
    }

    @Override
    public void setItemImage(ImageView itemImage, int index) {
        if(itemImage != null){
            if(index == 0) {
                FirstItemAnchor.setVisible(true);
                setFirstItemImage(itemImage);
            }
            if(index == 1){
                SecondItemAnchor.setVisible(true);
                setSecondItemImage(itemImage);
            }
        }
    }

    public void setFirstItemImage(ImageView itemImage) {
        FirstItemImage.setImage(itemImage.getImage());
    }

    public void setSecondItemImage(ImageView itemImage) {
        SecondItemImage.setImage(itemImage.getImage());
    }

    @Override
    public void updateMonsterHPBar(int remainingVitality, int maxVitality) {

    }

    @Override
    public void hideInventory() {
        FirstItemAnchor.setVisible(false);
        SecondItemAnchor.setVisible(false);
    }

    @Override
    public void resetItemImages() {
        selected = 0;
        firstItemSelector.setVisible(false);
        secondItemSelector.setVisible(false);
        FirstItemImage.setImage(null);
        SecondItemImage.setImage(null);
        FirstItemNumber.setText("");
        SecondItemNumber.setText("");

    }

    @Override
    public void setStrengthViewer(int strength) {
        StrengthViewer.setText(String.valueOf(strength));
    }

    public void clearRoomComponentImage() {
        ComponentImage.setImage(null);
    }

    public void showDoor() {
        DoorAnchor.setVisible(true);
    }

    public void hideDoor() {
        DoorAnchor.setVisible(false);
    }


    public void animateTurningRight(){
        //Creating Translate Transition
        TranslateTransition translateTransitionLeftToCenter = new TranslateTransition();

        //Setting the duration of the transition
        translateTransitionLeftToCenter.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        translateTransitionLeftToCenter.setNode(GameVisualisation);

        //Setting the value of the transition along the x axis.
        translateTransitionLeftToCenter.setFromX(330);
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
        translateTransitionCenterToRight.setToX(-420);

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
        translateTransitionCenterToLeft.setToX(330);

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
        translateTransitionRightToCenter.setFromX(-420);
        translateTransitionRightToCenter.setToX(0);

        //Setting the cycle count for the transition
        translateTransitionRightToCenter.setCycleCount(1);

        //Setting auto reverse value to false
        translateTransitionRightToCenter.setAutoReverse(false);


        SequentialTransition seqT = new SequentialTransition(translateTransitionCenterToLeft, translateTransitionRightToCenter);
        seqT.play();

    }

}

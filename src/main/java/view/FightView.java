package view;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;

public class FightView implements View{
    public AnchorPane MainView;
    public ImageView RoomViewer;
    public AnchorPane PlayerAnchor;
    public ImageView PlayerImage;
    public AnchorPane EnemyAnchor;
    public ImageView EnemyImage;
    public Rectangle HPBar;
    public Rectangle HPBarMonster;
    SequentialTransition seqT;

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

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void setRoomComponentImage(ImageView image) {
        EnemyImage.setImage(image.getImage());
    }

    @Override
    public void setUIText(String text) {

    }

    @Override
    public void setEquippedItemVisible(int index) {

    }

    @Override
    public void setNumberOfItems(ArrayList<Integer> itemsNumbers) {

    }

    @Override
    public void setNumberVisible(int index) {

    }

    @Override
    public void playerAttack(int playerVitality, int playerInitVitality, int enemyVitality, int enemyInitVitality) {
        //Creating Translate Transition
        TranslateTransition playerAttack = new TranslateTransition();

        //Setting the duration of the transition
        playerAttack.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        playerAttack.setNode(PlayerAnchor);

        //Setting the value of the transition along the x axis.
        playerAttack.setFromX(0);
        playerAttack.setToX(450);

        //Setting the cycle count for the transition
        playerAttack.setCycleCount(2);

        //Setting auto reverse value to false
        playerAttack.setAutoReverse(true);

        playerAttack.play();

        playerAttack.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                enemyAttack();
            }
        });
    }

    private void enemyAttack() {
        //Creating Translate Transition
        TranslateTransition enemyAttack = new TranslateTransition();

        //Setting the duration of the transition
        enemyAttack.setDuration(Duration.millis(1000));

        //Setting the node for the transition
        enemyAttack.setNode(EnemyAnchor);

        //Setting the value of the transition along the x axis.
        enemyAttack.setFromX(0);
        enemyAttack.setToX(-290);

        //Setting the cycle count for the transition
        enemyAttack.setCycleCount(2);

        //Setting auto reverse value to false
        enemyAttack.setAutoReverse(true);

        enemyAttack.play();
    }

    @Override
    public void waitToClear(int millis) {

    }

    @Override
    public void waitToShow(int millis, boolean hasToShow) {

    }

    @Override
    public void updateHPBar(int remainingVitality, int maxVitality) {
        HPBar.setWidth(remainingVitality*245/maxVitality);
    }

    @Override
    public void setItemImage(ImageView itemImage, int index) {

    }


    @Override
    public void updateMonsterHPBar(int remainingVitality, int maxVitality) {
        HPBarMonster.setWidth(remainingVitality*245/maxVitality);
    }

    @Override
    public void hideInventory() {

    }

    @Override
    public void resetItemImages() {

    }

    @Override
    public void setStrengthViewer(int strength) {

    }

    @Override
    public void setSelector(int index) {

    }


}

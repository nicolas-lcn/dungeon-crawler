package view;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class FightView implements View{
    public AnchorPane MainView;
    public ImageView RoomViewer;
    public AnchorPane PlayerAnchor;
    public ImageView PlayerImage;
    public AnchorPane EnemyAnchor;
    public ImageView EnemyImage;
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
    public void inventoryNavLeft() {

    }

    @Override
    public void inventoryNavRight() {

    }

    @Override
    public void setEquippedItemVisible() {

    }

    @Override
    public void setNumberOfPotions(String numberOfPotions) {

    }

    @Override
    public void playerAttack() {
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

    @Override
    public void enemyAttack() {
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


}

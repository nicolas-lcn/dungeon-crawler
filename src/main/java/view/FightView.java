package view;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import javax.swing.*;
import java.io.File;
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


    Image monsterIdle = new Image(new File("src/main/java/view/assets/demon-idle.gif").toURI().toString());
    Image playerIdle = new Image(new File("src/main/java/view/assets/adventurer-idle.gif").toURI().toString());
    Image playerRunToRight = new Image(new File("src/main/java/view/assets/adventurer-run.gif").toURI().toString());
    Image playerRunToLeft = new Image(new File("src/main/java/view/assets/adventurer-run1.gif").toURI().toString());

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
        TranslateTransition playerToEnemy = new TranslateTransition();
        //Setting the duration of the transition
        playerToEnemy.setDuration(Duration.millis(500));

        //Setting the node for the transition
        playerToEnemy.setNode(PlayerAnchor);

        //Setting the value of the transition along the x axis.
        playerToEnemy.setFromX(0);
        playerToEnemy.setToX(300);

        playerToEnemy.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerImage.setImage(new Image(
                        new File("src/main/java/view/assets/playerAttack.gif").toURI().toString()
                        )
                );
            }
        });

        TranslateTransition playerEnemyToBack = new TranslateTransition();
        //Setting the duration of the transition
        playerEnemyToBack.setDuration(Duration.millis(500));

        //Setting the node for the transition
        playerEnemyToBack.setNode(PlayerAnchor);

        //Setting the value of the transition along the x axis.
        playerEnemyToBack.setFromX(300);
        playerEnemyToBack.setToX(0);

        playerEnemyToBack.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerImage.setImage(playerIdle);
            }
        });

        TranslateTransition playerAttackAnimation = new TranslateTransition();
        //Setting the duration of the transition
        playerAttackAnimation.setDuration(Duration.millis(500));

        //Setting the node for the transition
        playerAttackAnimation.setNode(PlayerAnchor);

        //Setting the value of the transition along the x axis.
        playerAttackAnimation.setFromX(300);
        playerAttackAnimation.setToX(300);

        playerAttackAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateMonsterHPBar(enemyVitality, enemyInitVitality);
                PlayerImage.setImage(playerRunToLeft);
            }
        });

        SequentialTransition sequentialTransition = new SequentialTransition(playerToEnemy, playerAttackAnimation, playerEnemyToBack);

        PlayerImage.setImage(playerRunToRight);
        sequentialTransition.play();
        sequentialTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (enemyVitality > 0)
                    FightView.this.enemyAttack(playerVitality, playerInitVitality);
            }
        });
    }

    private void enemyAttack(int playerVitality, int playerInitVitality) {
        //Creating Translate Transition
        TranslateTransition enemyToPlayer = new TranslateTransition();

        //Setting the duration of the transition
        enemyToPlayer.setDuration(Duration.millis(500));

        //Setting the node for the transition
        enemyToPlayer.setNode(EnemyAnchor);

        //Setting the value of the transition along the x axis.
        enemyToPlayer.setFromX(0);
        enemyToPlayer.setToX(-290);

        //Setting the cycle count for the transition
        enemyToPlayer.setCycleCount(1);

        //Setting auto reverse value to false
        enemyToPlayer.setAutoReverse(false);

        enemyToPlayer.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EnemyImage.setImage(new Image(
                        new File("src/main/java/view/assets/demon-attack.gif").toURI().toString()
                        )
                );
            }
        });

        //Creating Translate Transition
        TranslateTransition enemyAttackAnimation = new TranslateTransition();

        //Setting the duration of the transition
        enemyAttackAnimation.setDuration(Duration.millis(2000));

        //Setting the node for the transition
        enemyAttackAnimation.setNode(EnemyAnchor);

        //Setting the value of the transition along the x axis.
        enemyAttackAnimation.setFromX(-290);
        enemyAttackAnimation.setToX(-290);

        //Setting the cycle count for the transition
        enemyAttackAnimation.setCycleCount(1);

        //Setting auto reverse value to false
        enemyAttackAnimation.setAutoReverse(false);

        enemyAttackAnimation.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                updateHPBar(playerVitality, playerInitVitality);
                EnemyImage.setImage(monsterIdle);
            }
        });

        //Creating Translate Transition
        TranslateTransition enemyLeftToBack = new TranslateTransition();

        //Setting the duration of the transition
        enemyLeftToBack.setDuration(Duration.millis(500));

        //Setting the node for the transition
        enemyLeftToBack.setNode(EnemyAnchor);

        //Setting the value of the transition along the x axis.
        enemyLeftToBack.setFromX(-290);
        enemyLeftToBack.setToX(0);

        //Setting the cycle count for the transition
        enemyLeftToBack.setCycleCount(1);

        //Setting auto reverse value to false
        enemyLeftToBack.setAutoReverse(false);


        SequentialTransition sequentialTransition = new SequentialTransition(enemyToPlayer, enemyAttackAnimation, enemyLeftToBack);

        sequentialTransition.play();
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

package view;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class TitleScreenView implements View{
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
        System.out.println("called on " + this);
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
    public void inventoryNavLeft() {

    }

    @Override
    public void inventoryNavRight() {

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
    public void playerAttack() {

    }

    @Override
    public void enemyAttack() {

    }

    @Override
    public void waitToClear(int millis) {

    }

    @Override
    public void waitToShow(int millis, boolean hasToShow) {

    }

    @Override
    public void updateHPBar(int remainingVitality, int maxVitality) {

    }

    @Override
    public void setItemImage(ImageView itemImage, int index) {

    }


    @Override
    public void updateMonsterHPBar(int remainingVitality, int maxVitality) {

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


}

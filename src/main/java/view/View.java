package view;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public interface View {
    public void startGame();
    public void gameOver();
    public void titleScreen();
    public void openInventory();
    public void closeInventory();
    public void beginFight();
    public void stopFight();
    public void quitGame();
    public void setGameState();
    public void turnRight();
    public void turnLeft();
    public void setRoomComponentImage(ImageView image);
    public void setUIText(String text);
    void inventoryNavLeft();
    void inventoryNavRight();
    void setEquippedItemVisible(int index);
    void setNumberOfItems(ArrayList<Integer> itemsNumbers);
    void setNumberVisible(int index);
    void playerAttack();
    void enemyAttack();
    void waitToClear(int millis);
    void waitToShow(int millis, boolean hasToShow);
    void updateHPBar(int remainingVitality, int maxVitality);
    void setFirstItemImage(ImageView itemImage);
    void setSecondItemImage(ImageView itemImage);
    void updateMonsterHPBar(int remainingVitality, int maxVitality);

}

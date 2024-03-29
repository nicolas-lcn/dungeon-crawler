package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Character;
import model.Direction;
import model.Player;
import model.generators.ComponentGenerator;
import model.places.Dungeon;
import view.View;

public interface GameController {
    public void handleInventory();
    public void startGame();
    public void quitGame();
    public void handleUseItem();
    public void setEventHandler(KeyBoardController keyBoardController);
    public EventHandler<? super KeyEvent> getEventHandler();
    public void initGameState();
    public void setView(View view);
    public void setDungeon(Dungeon dungeon);
    public void setComponentGenerator(ComponentGenerator componentGenerator);
    public Player getPlayer();
    public void handleRotation(Direction direction);
    public void goForward();
    public void handleInventoryNavRight();
    public void handleInventoryNavLeft();
    void handleRight();
    void handleLeft();
    void handleFight(boolean hasStarted, Character enemyFighter);
    void handlePlayerAttackFirst();
    void handleAllPlayerPropertiesDisplay();
    public void setGameStarted(boolean gameStarted);
    public void reset();
}

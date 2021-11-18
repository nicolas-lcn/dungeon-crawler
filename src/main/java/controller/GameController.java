package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import model.Direction;

public interface GameController {
    public void handleMovement(Direction direction);
    public void handleInventory(boolean isOpened);
    public void startGame();
    public void quitGame();
    public void handleUseItem();
    public void setEventHandler(KeyBoardController keyBoardController);
    public EventHandler<? super KeyEvent> getEventHandler();
    public void initGameState();
}

package model.states;

import controller.FXSceneController;
import model.Direction;
import model.GameState;
import model.Item;

public abstract class State {
    public GameState gameState;
    public FXSceneController sceneController = FXSceneController.getInstance();

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public abstract void openInventory();
    public abstract void closeInventory();
    public abstract void gameOver();
    public abstract void titleScreen();
    public abstract void pauseGame();
    public abstract void resumeGame();
    public abstract void startFight();
    public abstract void endFight();
    public abstract void handleUseItem(Item item);
    public abstract void handleMovement(Direction direction);
}

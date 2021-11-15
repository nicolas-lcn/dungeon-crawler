package model.states;

import model.GameState;
import view.JavaFXView;

public abstract class State {
    public GameState gameState;

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
}

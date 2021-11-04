package model.states;

public interface State {
    void openInventory();
    void closeInventory();
    void gameOver();
    void titleScreen();
    void pauseGame();
    void resumeGame();
    void startFight();
    void endFight();
}

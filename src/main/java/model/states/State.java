package model.states;

public interface State {
    public void openInventory();
    public void closeInventory();
    public void gameOver();
    public void titleScreen();
    public void pauseGame();
    public void resumeGame();
    public void startFight();
    public void endFight();
}

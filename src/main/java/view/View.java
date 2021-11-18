package view;

import model.Direction;

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
    public void handleMovement(Direction oldDirection, Direction newDirection);
}

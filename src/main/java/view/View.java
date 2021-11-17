package view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Direction;
import model.Move;

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
}

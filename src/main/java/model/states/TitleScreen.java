package model.states;

import model.Character;
import model.Direction;
import model.Inventory;
import model.Item;

import java.io.IOException;

public class TitleScreen extends State {

    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public void gameOver() {}

    @Override
    public void titleScreen() {
        System.out.println("Bienvenue dans Dungeon, appuyer sur G pour lancer la partie");
        try {
            sceneController.switchTitleScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pauseGame() {}

    @Override
    public void resumeGame() {
        System.out.println("Lancement de la partie...");
        State state = new InGame();
        try {
            sceneController.switchInGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameState.setState(state);
        state.setGameState(gameState);
    }

    @Override
    public void startFight(Character enemyFighter) {}

    @Override
    public void endFight() {}

    @Override
    public void handleUseItem(Inventory inventory, Item item) {

    }
}

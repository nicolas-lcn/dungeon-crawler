package model.states;

import model.*;
import model.Character;
import model.places.Dungeon;

import java.io.IOException;

public class GameOver extends State {
    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public void gameOver() {}

    @Override
    public void titleScreen() {
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

    @Override
    public void handleMovement(Move move, Player player, Dungeon dungeon) {

    }

}

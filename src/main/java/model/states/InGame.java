package model.states;

import model.Character;
import model.Direction;
import model.Inventory;
import model.Item;

import java.io.IOException;

public class InGame extends State {
    @Override
    public void openInventory() {
        System.out.println("Voici votre Inventaire : ");
        State state = new InventoryState();
        gameState.setState(state);
        state.setGameState(gameState);
    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void gameOver() {
        System.out.println("Vous avez perdu...");
        State state = new GameOver();
        gameState.setState(state);
        try {
            sceneController.switchGameOver();
        } catch (IOException e) {
            e.printStackTrace();
        }
        state.setGameState(gameState);
    }

    @Override
    public void titleScreen() {}

    @Override
    public void pauseGame() {
        System.out.println("Jeu mis en pause...");
        State state = new GamePaused();
        gameState.setState(state);
        state.setGameState(gameState);
    }

    @Override
    public void resumeGame() {}

    @Override
    public void startFight(Character enemyFighter) {
        System.out.println("Le combat commence ! ");
        State state = new FightState();
        gameState.setState(state);
        try {
            sceneController.switchFightScreen(enemyFighter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        state.setGameState(gameState);

    }

    @Override
    public void endFight() {}

    @Override
    public void handleUseItem(Inventory inventory, Item item) {

    }

}

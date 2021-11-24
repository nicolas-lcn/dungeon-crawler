package model.states;

import model.*;
import model.Character;
import model.places.Dungeon;

public class InventoryState extends State {
    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {
        System.out.println("Fermeture de l'inventaire");
        resumeGame();
    }

    @Override
    public void gameOver() {}

    @Override
    public void titleScreen() {}

    @Override
    public void pauseGame() {}

    @Override
    public void resumeGame() {
        System.out.println("Retour au jeu...");
        State state = new InGame();
        gameState.setState(state);
        state.setGameState(gameState);
    }

    @Override
    public void startFight(Character enemyFighter) {}

    @Override
    public void endFight() {}

    @Override
    public void handleUseItem(Inventory inventory, Item item) {
        inventory.useItem(item);
    }

    @Override
    public void handleMovement(Move move, Player player, Dungeon dungeon) {

    }

}

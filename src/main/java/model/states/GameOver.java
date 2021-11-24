package model.states;

import model.*;
import model.Character;
import model.places.Dungeon;

public class GameOver extends State {
    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public void gameOver() {}

    @Override
    public void titleScreen() {
        State state = new TitleScreen();
        gameState.setState(state);
        state.setGameState(gameState);
    }

    @Override
    public void pauseGame() {}

    @Override
    public void resumeGame() {}

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

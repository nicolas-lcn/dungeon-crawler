package model.states;

import model.Character;
import model.Direction;
import model.Item;

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
    public void handleUseItem(Item item) {

    }

    @Override
    public void handleMovement(Direction direction) {

    }
}

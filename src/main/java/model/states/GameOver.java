package model.states;

import model.states.State;

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
    public void startFight() {}

    @Override
    public void endFight() {}
}

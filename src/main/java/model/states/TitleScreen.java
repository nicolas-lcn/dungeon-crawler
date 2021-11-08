package model.states;

import model.GameState;

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
    }

    @Override
    public void pauseGame() {}

    @Override
    public void resumeGame() {
        System.out.println("Lancement de la partie...");
        State state = new InGame();
        gameState.setState(state);
        state.setGameState(gameState);
    }

    @Override
    public void startFight() {}

    @Override
    public void endFight() {}
}

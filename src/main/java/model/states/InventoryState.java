package model.states;

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
    public void startFight() {}

    @Override
    public void endFight() {}
}

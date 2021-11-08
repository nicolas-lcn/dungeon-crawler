package model.states;

public class FightState extends State{
    @Override
    public void openInventory() {}

    @Override
    public void closeInventory() {}

    @Override
    public void gameOver() {}

    @Override
    public void titleScreen() {}

    @Override
    public void pauseGame() {}

    @Override
    public void resumeGame() {}

    @Override
    public void startFight() {}

    @Override
    public void endFight() {
        System.out.println("Retour au jeu...");
        State state = new InGame();
        gameState.setState(state);
        state.setGameState(gameState);
    }
}

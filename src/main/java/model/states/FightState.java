package model.states;

import model.Character;
import model.Direction;
import model.Item;

import java.io.IOException;

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
    public void startFight(Character enemyFighter) {}

    @Override
    public void endFight(){
        System.out.println("Retour au jeu...");
        State state = new InGame();
        gameState.setState(state);
        state.setGameState(gameState);
        try {
            sceneController.stopFight();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleUseItem(Item item) {

    }

    @Override
    public void handleMovement(Direction direction) {

    }
}

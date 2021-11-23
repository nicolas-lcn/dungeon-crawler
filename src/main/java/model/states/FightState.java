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
    public void pauseGame() {}

    @Override
    public void resumeGame() {
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
    public void endFight(){
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

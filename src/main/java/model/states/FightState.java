package model.states;

import model.*;
import model.Character;
import model.places.Dungeon;

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
            System.out.println("Le combat est terminé !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handleUseItem(Inventory inventory, Item item) {

    }

    @Override
    public void handleMovement(Move move, Player player, Dungeon dungeon) {

    }

}

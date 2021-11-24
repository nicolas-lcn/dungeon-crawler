package model;

import model.places.Dungeon;
import model.states.*;

public class GameState {
    public State state;

    public static GameState instance;

    public GameState(){
        this.state = new TitleScreen();
        this.state.setGameState(this);
        this.titleScreen();
    }

    public static GameState getInstance() {
        if(instance == null) instance = new GameState();
        return instance;
    }

    public void setState(State state){
        this.state = state;
    }


    public void openInventory() {
        state.openInventory();
    }

    public void closeInventory() {
        state.closeInventory();
    }

    public void gameOver() {
        state.gameOver();
    }

    public void titleScreen() {
        state.titleScreen();
    }

    public void pauseGame() {
        state.pauseGame();
    }

    public void resumeGame() {
        state.resumeGame();
    }

    public void startFight(Character enemyFighter) {
        state.startFight(enemyFighter);
    }

    public void endFight() {
        state.endFight();
    }

    public void handleUseItem(Inventory inventory, Item item) {
        state.handleUseItem(inventory, item);
    }

    public void handleMovement(Move move, Player player, Dungeon dungeon){
        state.handleMovement(move, player, dungeon);
    }



}

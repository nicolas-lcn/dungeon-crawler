package model;

import model.states.*;

public class GameState {
    public State state;

    public GameState(){
        this.state = new TitleScreen();
        this.state.setGameState(this);
        this.titleScreen();
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

    public void startFight() {
        state.startFight();
    }

    public void endFight() {
        state.endFight();
    }


}

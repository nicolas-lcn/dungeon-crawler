package model.states;

import model.Character;

public abstract class Fight implements State {
    public abstract void begin(Character player, Character enemy);
    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public void gameOver() {

    }

    @Override
    public void titleScreen() {

    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void resumeGame() {

    }

    @Override
    public void startFight() {

    }

    @Override
    public void endFight() {

    }
}

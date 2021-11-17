package controller;

import model.Direction;

public interface GameController {
    public void handleMovement(Direction direction);
    public void handleInventory(boolean isOpened);
}

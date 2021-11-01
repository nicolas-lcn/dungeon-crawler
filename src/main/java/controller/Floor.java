package controller;

import model.Character;
import model.Direction;
import model.Move;
import model.Room;

public interface Floor {
    public static int MAX_ROOM_NUMBER = 10;
    public void exitRoom(Move move, Character player);
    public int getPlayerPositionX();
    public int getPlayerPositionY();
    public void addRoom(Direction direction, Character player);
    public Room getCurrentRoom();
}

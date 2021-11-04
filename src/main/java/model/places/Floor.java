package model.places;

import model.*;

public interface Floor {
    public static int MAX_ROOM_NUMBER = 10;
    public void exitRoom(Move move, Player player);
    public int getPlayerPositionX();
    public int getPlayerPositionY();
    public void addRoom(Direction direction,Player player);
    public Room getCurrentRoom();
}

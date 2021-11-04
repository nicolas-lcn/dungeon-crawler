package model.places;

import controller.RandomController;
import model.Direction;
import model.Move;
import model.Player;
import model.places.Floor;
import model.places.Room;
import model.places.SimpleRoom;

import java.util.ArrayList;

public class SimpleFloor implements Floor {

    private int playerPositionX;
    private ArrayList<SimpleRoom> map;


    public SimpleFloor(Direction previousDirection, Player player){
        map = new ArrayList<>(MAX_ROOM_NUMBER);
        playerPositionX = 0;
        addRoom(previousDirection, player);
    }



    @Override
    public void exitRoom(Move move, Player player) {
        addRoom(move.getOpposedDirection(), player);
        System.out.println("on est sorti");
        playerPositionX++;
    }

    @Override
    public int getPlayerPositionX() {
        return playerPositionX;
    }

    @Override
    public int getPlayerPositionY() {
        return 0;
    }


    @Override
    public void addRoom(Direction direction, Player player) {
        SimpleRoom room = new SimpleRoom(RandomController.randomComponent(), RandomController.randomPortalNumber(), direction);
        map.add(room);
        room.interact(player);
    }

    @Override
    public Room getCurrentRoom() {
        return map.get(playerPositionX);
    }
}
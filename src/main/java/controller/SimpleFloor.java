package controller;

import model.*;
import model.Character;

import java.util.ArrayList;

public class SimpleFloor implements Floor{

    private int playerPositionX;
    private ArrayList<SimpleRoom> map;


    public SimpleFloor(Direction previousDirection, Character player){
        map = new ArrayList<>(MAX_ROOM_NUMBER);
        playerPositionX = 0;
        addRoom(previousDirection, player);
    }



    @Override
    public void exitRoom(Move move, Character player) {
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
    public void addRoom(Direction direction, Character player) {
        SimpleRoom room = new SimpleRoom(RandomController.randomComponent(), RandomController.randomPortalNumber(), direction);
        map.add(room);
        room.interact(player);
    }

    @Override
    public Room getCurrentRoom() {
        return map.get(playerPositionX);
    }
}

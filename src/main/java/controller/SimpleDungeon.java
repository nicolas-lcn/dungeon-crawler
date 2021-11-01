package controller;

import model.Direction;
import model.Move;
import model.Character;

public class SimpleDungeon extends Dungeon{

    public SimpleDungeon(Direction direction, Character player){
        floorIndex = 0;
        addFloor(direction, player);
    }

    @Override
    public void exitFloor(Move move, Character player) {
        addFloor(move.getOpposedDirection(), player);
        floorIndex++;
    }

    @Override
    public void addFloor(Direction direction, Character player) {
        maps.add(new SimpleFloor(direction, player));
    }

    @Override
    public boolean isFloorEnd() {
        return maps.get(floorIndex).getPlayerPositionX()>= Floor.MAX_ROOM_NUMBER;
    }
}

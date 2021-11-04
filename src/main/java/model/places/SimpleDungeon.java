package model.places;

import model.Direction;
import model.Move;
import model.Player;

public class SimpleDungeon extends Dungeon {

    public SimpleDungeon(Direction direction, Player player){
        floorIndex = 0;
        addFloor(direction, player);
    }

    @Override
    public void exitFloor(Move move, Player player) {
        addFloor(move.getOpposedDirection(), player);
        floorIndex++;
    }

    @Override
    public void addFloor(Direction direction, Player player) {
        maps.add(new SimpleFloor(direction, player));
    }

    @Override
    public boolean isFloorEnd() {
        return maps.get(floorIndex).getPlayerPositionX()>= Floor.MAX_ROOM_NUMBER;
    }
}

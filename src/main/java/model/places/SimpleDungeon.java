package model.places;

import model.Direction;
import model.Move;
import model.Player;
import model.generators.ComponentGenerator;

public class SimpleDungeon extends Dungeon {

    private ComponentGenerator componentGenerator;

    public SimpleDungeon(Direction direction, Player player, ComponentGenerator componentGenerator){
        this.componentGenerator = componentGenerator;
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
        maps.add(new SimpleFloor(direction, player, componentGenerator));
    }

    @Override
    public boolean isFloorEnd() {
        return maps.get(floorIndex).getPlayerPositionX()>= Floor.MAX_ROOM_NUMBER;
    }
}

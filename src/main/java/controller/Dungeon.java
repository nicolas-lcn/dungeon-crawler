package controller;

import model.Direction;
import model.Move;
import model.Character;

import java.util.ArrayList;

public abstract class Dungeon {
    public static final int MAX_FLOOR_NUMBER = 5;
    public final ArrayList<Floor> maps = new ArrayList<>(MAX_FLOOR_NUMBER);
    protected int floorIndex;

    public abstract void exitFloor(Move move, Character player);

    public abstract void addFloor(Direction direction, Character player );

    public abstract boolean isFloorEnd();

    public Floor getCurrentFloor(){
        return maps.get(floorIndex);
    }
}

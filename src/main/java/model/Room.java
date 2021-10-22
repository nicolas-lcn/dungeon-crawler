package model;

import java.util.ArrayList;

public abstract class Room {

    private Component component;
    private int nbPortals;
    private Direction previousDirection;

    public Room(Component component, int nbPortals, Direction previousDirection) {
        this.component = component;
        this.nbPortals = nbPortals;
        this.previousDirection = previousDirection;
    }

    public void interact(){
        component.interact();
    }

    public void removeComponent(){
        //TODO
    }

    public abstract ArrayList<Direction> possibleDirections();
}

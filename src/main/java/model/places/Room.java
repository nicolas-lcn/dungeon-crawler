package model.places;

import model.components.Component;
import model.Direction;
import model.Player;

import java.util.ArrayList;

public abstract class Room {

    protected final Component component;
    protected final int nbPortals;
    protected final Direction previousDirection;
    protected final ArrayList<Direction> possibleDirections;

    public Room(Component component, int nbPortals, Direction previousDirection) {
        this.component = component;
        this.nbPortals = nbPortals;
        this.previousDirection = previousDirection;
        this.possibleDirections = new ArrayList<>();
    }

    public void interact(Player player){
        component.interact(player);
    }

    public void removeComponent(){
        //TODO
    }

    public abstract ArrayList<Direction> possibleDirections();
}

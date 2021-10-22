package model;

import controller.RandomController;

import java.util.ArrayList;

public class SimpleRoom extends Room{
    private Component component;
    private int nbPortals;
    private Direction previousDirection;
    public SimpleRoom(Component component, int nbPortals, Direction previousDirection) {
        super(component, nbPortals,previousDirection);
    }


    @Override
    public ArrayList<Direction> possibleDirections() {
        ArrayList<Direction> possibleDirections = new ArrayList<>();
        for(int portalNumber = 0; portalNumber<nbPortals; portalNumber++){
            Direction direction = RandomController.randomDirection();
            if (direction != previousDirection) possibleDirections.add(direction);
        }
        return possibleDirections;
    }
}

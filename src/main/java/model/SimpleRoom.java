package model;

import controller.RandomController;

import java.util.ArrayList;

public class SimpleRoom extends Room{

    public SimpleRoom(Component component, int nbPortals, Direction previousDirection) {
        super(component, nbPortals, previousDirection);
        for(int portalNumber = 0; portalNumber<nbPortals; portalNumber++){
            Direction direction = RandomController.randomDirection();
            if (direction != previousDirection) possibleDirections.add(direction);
        }
    }

    @Override
    public ArrayList<Direction> possibleDirections() {
        return possibleDirections;
    }
}

package model.places;

import controller.RandomController;
import model.components.Component;
import model.Direction;

import java.util.ArrayList;

public class SimpleRoom extends Room {

    public SimpleRoom(Component component, int nbPortals, Direction previousDirection) {
        super(component, nbPortals, previousDirection);
        for(int portalNumber = 0; portalNumber<nbPortals;){
            Direction direction = RandomController.randomDirection();
            if (direction != previousDirection && !possibleDirections().contains(direction)){
                portalNumber++;
                possibleDirections.add(direction);
            }
        }
    }

    @Override
    public ArrayList<Direction> possibleDirections() {
        return possibleDirections;
    }
}

package model;

public class SimpleMove implements Move {
    private Direction direction;

    public SimpleMove(Direction direction) {
        this.direction = direction;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public Direction getOpposedDirection(){
        switch(direction){
            case North:return Direction.South;
            case East:return Direction.West;
            case West:return Direction.East;
            default:return Direction.North;
        }
    }
}

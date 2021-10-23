package model;

public class Move {
    private Direction direction;

    public Move(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Direction getOpposedDirection(){
        switch(direction){
            case North:return Direction.South;
            case East:return Direction.West;
            case West:return Direction.East;
            default:return Direction.North;
        }
    }
}

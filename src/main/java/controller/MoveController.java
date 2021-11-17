package controller;

import model.*;
import model.places.Dungeon;
import model.places.Floor;
import model.places.Room;

public class MoveController {

    public static boolean isMoveAuthorized(Move move, Room room){
        return room.possibleDirections().contains(move.getDirection());
    }

    public static void applyMove(Move move, Dungeon dungeon, Player player) {
        if (isMoveAuthorized(move, dungeon.getCurrentFloor().getCurrentRoom())){
            if (dungeon.isFloorEnd()) dungeon.exitFloor(move, player);
            dungeon.getCurrentFloor().exitRoom(move, player);
        }
        else{
            System.out.println("Un mur se trouve devant vous");
        }
    }
}

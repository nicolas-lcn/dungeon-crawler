package controller;

import model.*;
import model.places.Floor;
import model.places.Room;

public class MoveController {

    public static boolean isMoveAuthorized(Move move, Room room){
        return room.possibleDirections().contains(move.getDirection());
    }

    public static void applyMove(Move move, Room room, Player player, Floor floor){
        if(isMoveAuthorized(move, room) /*&& player.getLookingDirection().equals(move.getDirection())*/) floor.exitRoom(move, player);
        else{
            System.out.println("Move unauthorized");
        }
    }
}

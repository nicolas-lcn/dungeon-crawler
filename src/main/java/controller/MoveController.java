package controller;

import model.Move;
import model.Room;
import model.Character;

public class MoveController {

    public static boolean isMoveAuthorized(Move move, Room room){
        return room.possibleDirections().contains(move.getDirection());
    }

    public static void applyMove(Move move, Room room, Character player, Floor floor){
        if(isMoveAuthorized(move, room)) floor.exitRoom(move, player);
        else{
            System.out.println("Move unauthorized");
        }
    }
}

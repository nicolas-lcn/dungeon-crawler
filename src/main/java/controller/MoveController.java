package controller;

import model.Move;
import model.Room;

public class MoveController {

    public boolean isMoveAuthorized(Move move, Room room){
        return room.possibleDirections().contains(move.getDirection());
    }

    public void applyMove(Move move, Room room, RoomController controller){
        if(isMoveAuthorized(move, room)) controller.getOut(move);
        else System.out.println("A wall is in the way");
    }
}

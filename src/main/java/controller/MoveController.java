package controller;

import model.Move;
import model.Room;
import model.Character;

public class MoveController {

    public boolean isMoveAuthorized(Move move, Room room){
        return room.possibleDirections().contains(move.getDirection());
    }

    public void applyMove(Move move, Room room, Character player){

    }
}
